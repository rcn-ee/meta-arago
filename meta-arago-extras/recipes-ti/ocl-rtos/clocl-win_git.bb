SUMMARY = "TI OpenCL-C compiler for C66x (Windows hosted)"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/opencl/intro.html"
LICENSE = "BSD"

require recipes-ti/ocl/ocl.inc
require recipes-ti/includes/arago-paths.inc

PR = "${INC_PR}.0"

CLOCL_WIN_GIT_URI = "git://git.ti.com/opencl/clocl-win.git"
CLOCL_WIN_GIT_BRANCH = "master"
CLOCL_WIN_SRCREV = "eac7ac7cc2e64a9ff05e4238e44dff3f9a9fcf6b"

BRANCH = "${CLOCL_WIN_GIT_BRANCH}"
SRC_URI = "${CLOCL_WIN_GIT_URI};protocol=git;branch=${BRANCH}"
SRCREV = "${CLOCL_WIN_SRCREV}"

LIC_FILES_CHKSUM = "file://opencl-manifest.html;md5=e0810676ad435e2ef53c1a538e24a9a7"

COMPATIBLE_MACHINE = "omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RELEASE_TARGET = ""
RELEASE_TARGET_omap-a15 = "am57xx"

S = "${WORKDIR}/git"
export DESTDIR="${OCL_RTOS_INSTALL_DIR}/ti-opencl-rtos-${RELEASE_TARGET}-${PV}/packages/ti/opencl"

do_install() {
    install -d ${DESTDIR}/usr/share/ti/opencl/bin/pc
    install -m 755 ${S}/bin/clocl.exe ${DESTDIR}/usr/share/ti/opencl/bin/pc
}
