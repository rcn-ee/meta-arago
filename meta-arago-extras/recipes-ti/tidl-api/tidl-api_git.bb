SUMMARY = "TIDL API"
DESCRIPTION = "TIDL API header and library. Refer TIDL API User's Guide for details."
HOMEPAGE = "https://downloads.ti.com/mctools/esd/docs/tidl-api/intro.html"
LICENSE = "BSD"

include tidl-api.inc
require recipes-ti/includes/ti-paths.inc

PR = "${INC_PR}.0"

COMPATIBLE_MACHINE = "am57xx-evm|am57xx-hs-evm"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit python3native

DEPENDS = "opencv \
           opencl \
           opencl-monitor \
           ti-cgt6x-native \
           clocl-native \
"

RDEPENDS_${PN} += "opencl-runtime \
                   opencv \
"

S = "${WORKDIR}/git"

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
    cp ${CP_ARGS} ${S}/tidl_api/* ${D}${TIDL_INSTALL_DIR}/tidl_api/
    cp ${CP_ARGS} ${S}/viewer/* ${D}${TIDL_INSTALL_DIR}/viewer/
    install ${S}/readme.md ${D}${TIDL_INSTALL_DIR}/
}

FILES_${PN} += "\
    ${TIDL_INSTALL_DIR} \
"


INSANE_SKIP_${PN} = "arch ldflags textrel staticdev"
