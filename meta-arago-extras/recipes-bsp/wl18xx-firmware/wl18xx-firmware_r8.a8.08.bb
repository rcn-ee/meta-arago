DESCRIPTION = "Firmware files for use with TI wl18xx"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENCE;md5=4977a0fe767ee17765ae63c435a32a9e"

PACKAGE_ARCH = "all"

PR = "r0+gitr${SRCPV}"

PROVIDES += "wl12xx-firmware"
RPROVIDES_${PN} += "wl12xx-firmware"
RREPLACES_${PN} += "wl12xx-firmware"
RCONFLICTS_${PN} += "wl12xx-firmware"

# Tag: ol_r8.a8.08
SRCREV = "8e7f455e726f2bf92c568286a5cca510d7718dc1"
SRC_URI = "git://github.com/TI-OpenLink/wl18xx_fw.git;protocol=git \
           file://Makefile \
          "

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    cp ${WORKDIR}/Makefile ${S}
    oe_runmake 'DEST_DIR=${D}' install
}

FILES_${PN} = "/lib/firmware/ti-connectivity/*"
