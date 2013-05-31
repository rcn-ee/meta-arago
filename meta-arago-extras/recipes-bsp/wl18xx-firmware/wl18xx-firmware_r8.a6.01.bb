DESCRIPTION = "Firmware files for use with TI wl18xx"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENCE;md5=b28122fd6678e89fd3a8d4bc80922969"

PACKAGE_ARCH = "all"

PR = "r2+gitr${SRCPV}"

PROVIDES += "wl12xx-firmware"
RPROVIDES_${PN} += "wl12xx-firmware"
RREPLACES_${PN} += "wl12xx-firmware"
RCONFLICTS_${PN} += "wl12xx-firmware"

# Tag: ol_r8.a6.01
SRCREV = "1c0f45f0e8aec0823175f7ac977908888c424aa1"
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
