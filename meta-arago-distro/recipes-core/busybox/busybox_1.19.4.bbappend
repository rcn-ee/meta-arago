# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago3"

SRC_URI += " \
	file://inetd \
	file://inetd.conf \
"

# Remove ${PN}-udhcpc from the list of init scripts since this was causing issues
# when using NFS for some machines. This mimics changes from the patch
# "busybox: udhcpc shouldn't be a service" commit "8329c4679ec0ce319d2a81d755a0da5b05474688"
# Once the patch mentioned above is pulled into the maintance branch the changes below can be
# removed.

FILES_${PN}-udhcpc := "${sysconfdir}/udhcpc.d ${datadir}/udhcpc"

INITSCRIPT_PACKAGES := "${@oe_filter_out('${PN}-udhcpc','${INITSCRIPT_PACKAGES}', d)}"

do_install_append () {
	if grep "CONFIG_UDHCPC=y" ${WORKDIR}/defconfig; then
		rm ${D}${sysconfdir}/init.d/busybox-udhcpc
	fi
}
