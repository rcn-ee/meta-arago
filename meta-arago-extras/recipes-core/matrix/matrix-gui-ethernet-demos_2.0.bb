DESCRIPTION = "Ethernet example applications"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

LICENSE = "CC-BY-SA-3.0 & GPLv2+"

LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM} \
                     file://../../udhcpd_eth1.conf;beginline=1;endline=14;md5=70668b1ed5416406a61ef9abdd90d601 \
"
PR = "${INC_PR}.1"

inherit allarch


# Add a default configuration file for the eth1 connection
SRC_URI += "file://udhcpd_eth1.conf"

S = "${WORKDIR}/git/ethernet_apps"

do_install_append() {
    install -d ${D}${sysconfdir}
    install -m 0755 ${WORKDIR}/udhcpd_eth1.conf ${D}${sysconfdir}
}

# Make sure ethernet submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-ethernet"

FILES_${PN} += "${MATRIX_BASE_DIR}/* \
                ${sysconfdir}/udhcpd_eth1.conf"
CONFFILES_${PN} += "${sysconfdir}/udhcpd_eth1.conf"
