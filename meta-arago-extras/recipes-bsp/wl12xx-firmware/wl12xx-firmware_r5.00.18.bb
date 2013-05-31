DESCRIPTION = "Firmware files for use with TI wl12xx"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENCE;md5=ba590e1d103f891d0151609046aef9e8"

PACKAGE_ARCH = "all"

PR = "r1+gitr${SRCPV}"

# This recipe provides the latest firmware files for wl12xx.
# Therefore, use the contents of this recipe instead of the contents
# of linux-firmware-wl12xx.
RCONFLICTS_${PN} = "linux-firmware-wl12xx"
RPROVIDES_${PN}  = "linux-firmware-wl12xx"

SRCREV = "38e0dd7999b9087e00d1a59306a7c22fd23246cf"
SRC_URI = "git://github.com/TI-ECS/ti-utils.git;protocol=git"

S = "${WORKDIR}/git/hw/firmware"

do_compile() {
    :
}

do_install() {
    oe_runmake 'DEST_DIR=${D}' install
}

FILES_${PN} = "/lib/firmware/ti-connectivity/*"
