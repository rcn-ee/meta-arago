# This is a TI specific version of the hostap-daemon recipe for use with the
# wl12xx wlan and bluetooth module.

HOMEPAGE = "http://hostap.epitest.fi"
DESCRIPTION = "User space daemon for extended IEEE 802.11 management"
SECTION = "kernel/userland"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../COPYING;md5=ab87f20cd7e8c0d0a6539b34d3791d0e"

DEPENDS = "libnl openssl"

# Since this is a TI customized version of hostap-daemon do not make this the
# default
DEFAULT_PREFERENCE = "-1"

inherit update-rc.d
INITSCRIPT_NAME="hostapd"

CONFFILES_${PN} += "${sysconfdir}/hostapd.conf"

# Add TI to the end to make it clear that this is a TI customized version
# of hostap
PV = "2.0-devel-ti"

PR = "r1+gitr${SRCPV}"

SRCREV = "ol_R5.SP3.05"

SRC_URI = "git://github.com/TI-OpenLink/hostap.git;protocol=git \
	file://0001-hostapd-change-conf-file-for-better-oob-startup.patch;patchdir=.. \
	file://defconfig \
	file://init"

S = "${WORKDIR}/git/hostapd"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CFLAGS += -I${STAGING_INCDIR}" >> .config
	echo "LIBS += -L${STAGING_LIBDIR}" >> .config
}

do_compile() {
	make
}

do_install() {
	install -d ${D}${sbindir} ${D}${sysconfdir}/init.d
	install -m 0644 ${S}/hostapd.conf ${D}${sysconfdir}
	install -m 0755 ${S}/hostapd ${D}${sbindir}
	install -m 0755 ${S}/hostapd_cli ${D}${sbindir}
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/hostapd
}

# The default hostapd.conf file that is fetched from upstream is using
# "a" band which is not supported by the 1271 chip.
# modify it to use "g" band and default channel 6 and change the ssid from
# "test" to a more meaningful name.

updatercd_postinst () {
:
}
