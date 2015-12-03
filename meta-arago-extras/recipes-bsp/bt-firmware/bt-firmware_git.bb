DESCRIPTION = "Firmware files for Bluetooth"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f39eac9f4573be5b012e8313831e72a9"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# This recipe provides the latest firmware files for wl12xx.
# Therefore, use the contents of this recipe instead of the contents
# of linux-firmware-wl12xx.
RCONFLICTS_${PN} = "linux-firmware-wl12xx"
RREPLACES_${PN}  = "linux-firmware-wl12xx"

PV = "R8.5+git${SRCPV}"
PR = "r10"

COMPATIBLE_MACHINE = "ti33x|ti43x|dra7xx"

CLEANBROKEN = "1"

SRCREV = "0c0eae241ea8a6e0b33d59f504741c8d5a2587ce"
BRANCH = "master"
SRC_URI = "git://git.ti.com/ti-bt/service-packs.git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    install -d ${D}${base_libdir}/firmware/ti-connectivity
    oe_runmake 'DEST_DIR=${D}' 'BASE_LIB_DIR=${base_libdir}' install
}

FILES_${PN} += "${base_libdir}/firmware/ti-connectivity/*"
