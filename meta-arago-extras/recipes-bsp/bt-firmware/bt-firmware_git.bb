DESCRIPTION = "Firmware files for Bluetooth"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://am335x/LICENCE;md5=ba590e1d103f891d0151609046aef9e8 \
                    file://am1808/LICENCE;md5=ba590e1d103f891d0151609046aef9e8 \
                    file://omap3evm/LICENCE;md5=ba590e1d103f891d0151609046aef9e8 \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# This recipe provides the latest firmware files for wl12xx.
# Therefore, use the contents of this recipe instead of the contents
# of linux-firmware-wl12xx.
RCONFLICTS_${PN} = "linux-firmware-wl12xx"
RREPLACES_${PN}  = "linux-firmware-wl12xx"

PR = "r1+gitr${SRCREV}"

COMPATIBLE_MACHINE = "omap3|omapl138|da850-omapl138-evm|ti33x"

SRCREV = "adbc27c11d5c5c8c20a93a8beca647b4a6aaa03b"
SRC_URI = "git://github.com/TI-ECS/bt-firmware.git;protocol=git \
           file://0001-Makefile-allow-building-within-the-OE.patch"

PLATFORM = "unknown"
PLATFORM_ti33x = "am335x-evm"
PLATFORM_omap3 = "am37x-evm"
PLATFORM_omapl138 = "am180x-evm"
PLATFORM_da850-omapl138-evm = "am180x-evm"

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    install -d ${D}${base_libdir}/firmware
    oe_runmake 'DEST_DIR=${D}' 'BASE_LIB_DIR=${base_libdir}' 'PLATFORM=${PLATFORM}' install
}

FILES_${PN} += "${base_libdir}/firmware"
