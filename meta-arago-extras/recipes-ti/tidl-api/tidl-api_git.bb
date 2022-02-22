SUMMARY = "TIDL API"
DESCRIPTION = "TIDL API header and library. Refer TIDL API User's Guide for details."
HOMEPAGE = "https://downloads.ti.com/mctools/esd/docs/tidl-api/intro.html"
LICENSE = "BSD"

include tidl-api.inc
require recipes-ti/includes/ti-paths.inc

PR = "${INC_PR}.0"

COMPATIBLE_MACHINE = "dra7xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit python3native

DEPENDS = "opencv \
           opencl \
           opencl-monitor \
           ti-cgt6x-native \
           clocl-native \
"

RDEPENDS:${PN} += "opencl-runtime \
                   opencv \
"

EXTRA_OEMAKE = " -C ${S}/tidl_api \
                 TARGET_ROOTDIR=${STAGING_DIR_HOST} \
                 TI_OCL_CGT_INSTALL=${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x \
"

do_compile() {
  oe_runmake
}

CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"

TIDL_INSTALL_DIR = "${datadir}/ti/tidl"

do_install() {
    install -d ${D}${TIDL_INSTALL_DIR}
    install -d ${D}${TIDL_INSTALL_DIR}/tidl_api
    install -d ${D}${TIDL_INSTALL_DIR}/viewer
    install -d ${D}${libdir}
    cp ${CP_ARGS} ${S}/tidl_api/libtidl_*.so* ${D}${libdir}
    rm -f ${S}/tidl_api/libtidl_*.so*
    cp ${CP_ARGS} ${S}/tidl_api/* ${D}${TIDL_INSTALL_DIR}/tidl_api/
    cp ${CP_ARGS} ${S}/viewer/* ${D}${TIDL_INSTALL_DIR}/viewer/
    install ${S}/readme.md ${D}${TIDL_INSTALL_DIR}/
}

FILES:${PN} += "\
    ${TIDL_INSTALL_DIR} \
"


INSANE_SKIP:${PN} = "arch ldflags textrel staticdev"
