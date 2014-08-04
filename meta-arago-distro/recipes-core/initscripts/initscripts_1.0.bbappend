PR_append = "-arago0"

# Overlay do_install from daisy
do_install () {
#
# Create directories and install device independent scripts
#
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	install -d ${D}${sysconfdir}/rc0.d
	install -d ${D}${sysconfdir}/rc1.d
	install -d ${D}${sysconfdir}/rc2.d
	install -d ${D}${sysconfdir}/rc3.d
	install -d ${D}${sysconfdir}/rc4.d
	install -d ${D}${sysconfdir}/rc5.d
	install -d ${D}${sysconfdir}/rc6.d
	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}/default/volatiles
	# Holds state information pertaining to urandom
	install -d ${D}/var/lib/urandom

	install -m 0644    ${WORKDIR}/functions		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/bootmisc.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/checkroot.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/halt		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/hostname.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/mountall.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/mountnfs.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/reboot		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/rmnologin.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/sendsigs		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/single		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/umountnfs.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/urandom		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/devpts.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/devpts		${D}${sysconfdir}/default
	install -m 0755    ${WORKDIR}/sysfs.sh		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/populate-volatile.sh ${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/read-only-rootfs-hook.sh ${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/save-rtc.sh	${D}${sysconfdir}/init.d
	install -m 0644    ${WORKDIR}/volatiles		${D}${sysconfdir}/default/volatiles/00_core
	install -m 0755    ${WORKDIR}/dmesg.sh		${D}${sysconfdir}/init.d
	install -m 0644    ${WORKDIR}/logrotate-dmesg.conf ${D}${sysconfdir}/

	if [ "${TARGET_ARCH}" = "arm" ]; then
		install -m 0755 ${WORKDIR}/alignment.sh	${D}${sysconfdir}/init.d
	fi
#
# Install device dependent scripts
#
	install -m 0755 ${WORKDIR}/banner.sh	${D}${sysconfdir}/init.d/banner.sh
	install -m 0755 ${WORKDIR}/umountfs	${D}${sysconfdir}/init.d/umountfs
#
# Create runlevel links
#
	update-rc.d -r ${D} rmnologin.sh start 99 2 3 4 5 .
	update-rc.d -r ${D} sendsigs start 20 0 6 .
	update-rc.d -r ${D} urandom start 30 S 0 6 .
	update-rc.d -r ${D} umountnfs.sh start 31 0 1 6 .
	update-rc.d -r ${D} umountfs start 40 0 6 .
	update-rc.d -r ${D} reboot start 90 6 .
	update-rc.d -r ${D} halt start 90 0 .
	update-rc.d -r ${D} save-rtc.sh start 25 0 6 .
	update-rc.d -r ${D} banner.sh start 02 S .
	update-rc.d -r ${D} checkroot.sh start 06 S .
	update-rc.d -r ${D} mountall.sh start 03 S .
	update-rc.d -r ${D} hostname.sh start 39 S .
	update-rc.d -r ${D} mountnfs.sh start 15 2 3 4 5 .
	update-rc.d -r ${D} bootmisc.sh start 55 S .
	update-rc.d -r ${D} sysfs.sh start 02 S .
	update-rc.d -r ${D} populate-volatile.sh start 37 S .
	update-rc.d -r ${D} read-only-rootfs-hook.sh start 29 S .
	update-rc.d -r ${D} devpts.sh start 38 S .
	if [ "${TARGET_ARCH}" = "arm" ]; then
	        update-rc.d -r ${D} alignment.sh start 06 S .
	fi
	# We wish to have /var/log ready at this stage so execute this after
	# populate-volatile.sh
	update-rc.d -r ${D} dmesg.sh start 38 S .
}
