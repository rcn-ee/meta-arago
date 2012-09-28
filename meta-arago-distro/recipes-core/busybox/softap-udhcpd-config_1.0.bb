DESCRIPTION = "Configuration files for SoftAP with udhcpd"
SECTION = "console/network"
HOMEPAGE = "http://udhcp.busybox.net/"
LICENSE = "GPLv2 & BSD-4-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=de10de48642ab74318e893a61105afbb"

PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

# Default configuration file is from the base udhcp package
SRC_URI = "file://udhcpd.conf \
           file://LICENSE"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0755 ${S}/udhcpd.conf ${D}${sysconfdir}
}

FILES_${PN} += "${sysconfdir}/udhcpd.conf"
CONFFILES_${PN} += "${sysconfdir}/udhcpd.conf"
