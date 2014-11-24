DESCRIPTION = "Firmware files for Bluetooth"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://am335x/LICENCE;md5=1c9961176d6529283e0d0c983be41b45 \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# This recipe provides the latest firmware files for wl12xx.
# Therefore, use the contents of this recipe instead of the contents
# of linux-firmware-wl12xx.
RCONFLICTS_${PN} = "linux-firmware-wl12xx"
RREPLACES_${PN}  = "linux-firmware-wl12xx"

PR = "r6+gitr${SRCPV}"

COMPATIBLE_MACHINE = "ti33x|ti43x|dra7xx-evm"

SRCREV = "fbcab22449ce930a4192ffeb470c168f4e85e0c6"
BRANCH = "master"
SRC_URI = "git://git.ti.com/wilink8-bt/ti-bt-firmware.git;branch=${BRANCH} \
           file://0001-Makefile-allow-building-within-the-OE.patch \
           file://0001-bt-firmware-Remove-platform-check-and-install-defaul.patch"

PLATFORM = "unknown"
PLATFORM_ti33x = "am335x-evm"
PLATFORM_ti43x = "am437x-evm"

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    install -d ${D}${base_libdir}/firmware
    oe_runmake 'DEST_DIR=${D}' 'BASE_LIB_DIR=${base_libdir}' 'PLATFORM=${PLATFORM}' install
}

FILES_${PN} += "${base_libdir}/firmware"
