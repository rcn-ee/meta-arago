SUMMARY = "TIDL API and examples"
DESCRIPTION = "TIDL API and examples of API usage. Refer TIDL API User's Guide for details."
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/tidl-api/intro.html"
LICENSE = "BSD"

include tidl-api.inc
require recipes-ti/includes/ti-paths.inc

PR = "${INC_PR}.0"

COMPATIBLE_MACHINE = "am57xx-evm|am57xx-hs-evm"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "opencv opencl opencl-monitor ti-cgt6x-native clocl-native"

RDEPENDS_${PN} += " opencl-runtime opencv"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = " -C ${S}/examples \
                 TARGET_ROOTDIR=${STAGING_DIR_HOST} \
                 TI_OCL_CGT_INSTALL=${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x \
"

do_compile() {
  oe_runmake
}

CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"

do_install() {
    install -d ${D}${datadir}/ti/tidl-api
    install -d ${D}${datadir}/ti/tidl-api/examples
    install -d ${D}${datadir}/ti/tidl-api/tidl_api
    install -d ${D}${datadir}/ti/tidl-api/viewer
    cp ${CP_ARGS} ${S}/examples/* ${D}${datadir}/ti/tidl-api/examples/
    cp ${CP_ARGS} ${S}/tidl_api/* ${D}${datadir}/ti/tidl-api/tidl_api/
    cp ${CP_ARGS} ${S}/viewer/* ${D}${datadir}/ti/tidl-api/viewer/
    install ${S}/readme.md ${D}${datadir}/ti/tidl-api/
}

FILES_${PN} += "\
    ${datadir}/ti/tidl-api \
"


INSANE_SKIP_${PN} = "arch ldflags textrel staticdev"
