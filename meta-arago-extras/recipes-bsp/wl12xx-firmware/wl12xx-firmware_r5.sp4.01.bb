DESCRIPTION = "Firmware files for use with TI wl12xx"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENCE;md5=ba590e1d103f891d0151609046aef9e8"

PACKAGE_ARCH = "all"

PR = "r3+gitr${SRCPV}"

# This recipe provides the latest firmware files for wl12xx.
# Therefore, use the contents of this recipe instead of the contents
# of linux-firmware-wl12xx.
RCONFLICTS_${PN} = "linux-firmware-wl12xx"
RPROVIDES_${PN}  = "linux-firmware-wl12xx"

# Tag: ol_R5.SP4.01
SRCREV = "c8d6b8e6ddf81091e1b1c99ebfb6751cc62b2c63"
SRC_URI = "git://github.com/TI-OpenLink/ti-utils.git;protocol=git \
           file://Makefile \
          "

S = "${WORKDIR}/git/hw/firmware"

do_compile() {
    :
}

do_install() {
    cp ${WORKDIR}/Makefile ${S}
    oe_runmake 'DEST_DIR=${D}' install
}

FILES_${PN} = "/lib/firmware/ti-connectivity/*"
