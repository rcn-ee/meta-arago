SUMMARY = "TI OpenVX HOST (Linux A15) conformance verification application, Khronos tutorial example, and Host side IPC implementation"
DESCRIPTION = "TI OpenVX implementation, TIOVX, includes Khronos defined conformance test and tutorial example, as well as additional TI \
specific tests. This package creates application which runs all the conformance tests (7K-8K) and Khronos tutorial exercise1. \
Same package includes IPC implementation (MessageQ based) needed for communication with DSP firmware (loaded at boot time)"

LICENSE = "BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://docs/manifest/TIOVX-APP-HOST_01.00.01.00_manifest.html;md5=247d7c56d783f583bf802490d5c93db3"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
     file://setenv.sh \
"

inherit pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "opencv"

require recipes-ti/includes/arago-paths.inc
require tiovx-sys.inc

DEPENDS = "tiovx-sys-iface tiovx-lib-host ti-ipc cmem opencv udev"
RDEPENDS:${PN} = "tiovx-sys-iface tiovx-sys-iface-firmware tiovx-lib-host ti-ipc cmem"

PR = "r3"

COMPATIBLE_MACHINE = "dra7xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PROCLIST = "host khronos_example"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += " TARGET_ROOTDIR=${STAGING_DIR_HOST} "
EXTRA_OEMAKE += " GCCLINARO=${TOOLCHAIN_PATH} TIOVXPATH=${TIOVX_INSTALL_DIR} IPCPATH=${IPC_INSTALL_DIR} "
EXTRA_OEMAKE += " SDKPLATFORMIFPATH=${TIOVX_INSTALL_DIR}/sys-iface "
EXTRA_OEMAKE += " PROC_LIST='${PROCLIST}' "

do_install () {
    install -d ${D}${bindir}/
    install -m 0755 ${S}/host/bin/debug/app_host ${D}${bindir}/tiovx-app_host
    install -m 0755 ${S}/khronos_example/bin/debug/opticalflow ${D}${bindir}/tiovx-opticalflow

    oe_runmake clean
    install -d ${D}${datadir}/ti/examples/openvx
    install -m 644 ${S}/products.mak ${D}${datadir}/ti/examples/openvx
    install -m 644 ${S}/makefile ${D}${datadir}/ti/examples/openvx
    install -m 644 ${WORKDIR}/setenv.sh ${D}${datadir}/ti/examples/openvx
    cp -r ${S}/host ${D}${datadir}/ti/examples/openvx
    cp -r ${S}/khronos_example  ${D}${datadir}/ti/examples/openvx
    cp -r ${S}/shared ${D}${datadir}/ti/examples/openvx
}

PACKAGES += "${PN}-examples"
FILES:${PN}-examples = "${datadir}/ti/examples/openvx"
RDEPENDS:${PN}-examples = "tiovx-lib-host-staticdev tiovx-lib-host-dev"

FILES:${PN} += "${bindir}/*"
INSANE_SKIP:${PN} = "ldflags"
INSANE_SKIP:${PN}-examples = "dev-deps"
