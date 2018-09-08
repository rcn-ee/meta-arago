SUMMARY = "OpenCL TIDL firmware for AM57xx"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE.ti;md5=082a028431c455252c1e1d3d1021d382"

PV = "01.01.16.00"
PR = "r0"

require recipes-ti/includes/arago-paths.inc

COMPATIBLE_MACHINE = "dra7xx"

PACKAGE_ARCH = "${MACHINE_ARCH}"

GIT_URI      = "git://git.ti.com/opencl/opencl-firmware.git"
GIT_PROTOCOL = "git"
BRANCH       = "master"
SRCREV       = "185e13d273fbbbbdb007111f87855f43c03535fa"

SRC_URI      = "${GIT_URI};protocol=${GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"

TARGET = "eve_firmware.bin ocl_tidl_dsp.lib"

do_install() {
    install -d ${D}${OCL_TIDL_FW_INSTALL_DIR_RECIPE}
    for f in ${TARGET}; do
	install -m 0644 ${S}/$f ${D}${OCL_TIDL_FW_INSTALL_DIR_RECIPE}/$f
    done
}

FILES_${PN} += "${OCL_TIDL_FW_INSTALL_DIR_RECIPE}"

INSANE_SKIP_${PN} = "arch"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
