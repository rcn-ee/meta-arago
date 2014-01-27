DESCRIPTION = "Firmware files for Bluetooth"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://am335x/LICENCE;md5=5f67a65df8b40038a3251b2fe5b912df \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# This recipe provides the latest firmware files for wl12xx.
# Therefore, use the contents of this recipe instead of the contents
# of linux-firmware-wl12xx.
RCONFLICTS_${PN} = "linux-firmware-wl12xx"
RREPLACES_${PN}  = "linux-firmware-wl12xx"

PR = "r3+gitr${SRCPV}"

COMPATIBLE_MACHINE = "ti33x"

SRCREV = "57a8e569575e742c47dc2452c4932dcfff816442"
SRC_URI = "git://github.com/TI-ECS/bt-firmware.git;protocol=git \
           file://0001-Makefile-allow-building-within-the-OE.patch"

PLATFORM = "unknown"
PLATFORM_ti33x = "am335x-evm"

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    install -d ${D}${base_libdir}/firmware
    oe_runmake 'DEST_DIR=${D}' 'BASE_LIB_DIR=${base_libdir}' 'PLATFORM=${PLATFORM}' install
}

FILES_${PN} += "${base_libdir}/firmware"
