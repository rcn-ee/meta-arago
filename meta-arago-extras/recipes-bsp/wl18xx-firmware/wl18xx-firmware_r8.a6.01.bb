DESCRIPTION = "Firmware files for use with TI wl18xx"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENCE;md5=b28122fd6678e89fd3a8d4bc80922969"

PACKAGE_ARCH = "all"

PR = "r1+gitr${SRCREV}"

PROVIDES += "wl12xx-firmware"
RPROVIDES_${PN} += "wl12xx-firmware"
RREPLACES_${PN} += "wl12xx-firmware"
RCONFLICTS_${PN} += "wl12xx-firmware"

SRCREV = "ol_r8.a6.01"
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
