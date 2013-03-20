# This is a TI specific version of the wpa-supplicant recipe for use with the
# wl12xx wlan and bluetooth module.

DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
BUGTRACKER = "http://hostap.epitest.fi/bugz/"
SECTION = "network"
LICENSE = "GPLv2 | BSD"

DEPENDS = "gnutls dbus libnl openssl ${@base_contains("COMBINED_FEATURES", "madwifi", "madwifi-ng", "",d)}"
RRECOMMENDS_${PN} = "wpa-supplicant-passphrase wpa-supplicant-cli"

# To prevent users from accidently picking up this customized version of
# wpa-supplicant the DEFAULT_PREFERENCE will be set to -1.
DEFAULT_PREFERENCE = "-1"

PR = "r6"

SRC_URI = "git://github.com/TI-OpenLink/hostap.git;protocol=git \
           file://defconfig \
           file://defaults-sane \
           file://wpa-supplicant.sh \
           file://wpa_supplicant.conf \
           file://wpa_supplicant.conf-sane \
           file://99_wpa_supplicant \
           file://wpa_supplicant.conf \
           file://fi.epitest.hostap.WPASupplicant.service \
           file://fi.w1.wpa_supplicant1.service \
          "

S = "${WORKDIR}/git/wpa_supplicant"

PACKAGES_prepend = "wpa-supplicant-passphrase wpa-supplicant-cli "
FILES_wpa-supplicant-passphrase = "/usr/sbin/wpa_passphrase"
FILES_wpa-supplicant-cli = "/usr/sbin/wpa_cli"
FILES_${PN} += " /usr/share/dbus-1/system-services/*"

#we introduce MY_ARCH to get 'armv5te' as arch instead of the misleading 'arm' on armv5te builds
MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('COMBINED_FEATURES', 'madwifi', '${MACHINE_ARCH}', '${MY_ARCH}', d)}"

do_compile () {
	make
}

do_install () {
	install -d ${D}${sbindir}
	install -m 755 wpa_supplicant ${D}${sbindir}
	install -m 755 wpa_passphrase ${D}${sbindir}
	install -m 755 wpa_cli        ${D}${sbindir}

	install -d ${D}${docdir}/wpa_supplicant
	install -m 644 README ${WORKDIR}/wpa_supplicant.conf ${D}${docdir}/wpa_supplicant

	install -d ${D}${sysconfdir}/default
	install -m 600 ${WORKDIR}/defaults-sane ${D}${sysconfdir}/default/wpa
	install -m 600 ${WORKDIR}/wpa_supplicant.conf-sane ${D}${sysconfdir}/wpa_supplicant.conf

	if grep -q ^CONFIG_CTRL_IFACE_DBUS=y .config || grep -q ^CONFIG_CTRL_IFACE_DBUS_NEW=y .config; then
		install -d ${D}/${sysconfdir}/dbus-1/system.d
		install -m 644 ${S}/dbus/dbus-wpa_supplicant.conf ${D}/${sysconfdir}/dbus-1/system.d
		install -d ${D}/${datadir}/dbus-1/system-services
		if grep -q ^CONFIG_CTRL_IFACE_DBUS=y .config; then
			sed -i -e s:/sbin:${sbindir}:g ${S}/dbus/fi.epitest.hostap.WPASupplicant.service
			install -m 644 ${S}/dbus/fi.epitest.hostap.WPASupplicant.service ${D}/${datadir}/dbus-1/system-services
		fi
		if grep -q ^CONFIG_CTRL_IFACE_DBUS_NEW=y .config; then
			sed -i -e s:/sbin:${sbindir}:g ${S}/dbus/fi.w1.wpa_supplicant1.service
			install -m 644 ${S}/dbus/fi.w1.wpa_supplicant1.service ${D}/${datadir}/dbus-1/system-services
		fi
	fi

	install -d ${D}${sysconfdir}/network/if-pre-up.d/
	install -d ${D}${sysconfdir}/network/if-post-down.d/
	install -d ${D}${sysconfdir}/network/if-down.d/
	install -m 644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}
	install -m 755 ${WORKDIR}/wpa-supplicant.sh ${D}${sysconfdir}/network/if-pre-up.d/wpa-supplicant
	cd ${D}${sysconfdir}/network/ && \
	ln -sf ../if-pre-up.d/wpa-supplicant if-post-down.d/wpa-supplicant

	install -d ${D}/etc/default/volatiles
	install -m 0644 ${WORKDIR}/99_wpa_supplicant ${D}/etc/default/volatiles

	install -d 2755 ${D}/usr/share/dbus-1/system-services
	install -d 2755 ${D}/etc
	install -m 644 ${WORKDIR}/wpa_supplicant.conf ${D}/etc
	install -m 644 ${WORKDIR}/fi.epitest.hostap.WPASupplicant.service ${D}/usr/share/dbus-1/system-services
	install -m 644 ${WORKDIR}/fi.w1.wpa_supplicant1.service ${D}/usr/share/dbus-1/system-services
}

pkg_postinst_wpa-supplicant () {
	# can't do this offline
	if [ "x$D" != "x" ]; then
		exit 1
	fi

	DBUSPID=`pidof dbus-daemon`

	if [ "x$DBUSPID" != "x" ]; then
		/etc/init.d/dbus-1 reload
	fi
}

do_configure () {
	install -m 0755 ${WORKDIR}/defconfig .config
	echo "CFLAGS += -I${STAGING_INCDIR}" >> .config
	echo "LIBS += -L${STAGING_LIBDIR}" >> .config
	echo "LIBS_p += -L${STAGING_LIBDIR}" >> .config
	if [ "${@base_contains('COMBINED_FEATURES', 'madwifi', 1, 0, d)}" = "1" ]; then
		echo "CONFIG_DRIVER_MADWIFI=y" >> .config
		echo "CFLAGS += -I${STAGING_INCDIR}/madwifi-ng" >> .config
	fi
}
