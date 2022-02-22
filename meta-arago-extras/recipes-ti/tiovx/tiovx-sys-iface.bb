SUMMARY = "TI OpenVX interface header files between TIOVX library and HOST, DSP IPC side implementation"
DESCRIPTION = "Collection of header files needed to define interface between TIOVX library and HOST and DSP IPC side implementation. \
In order to maintain source compatibility, directory structure follows VSDK source tree layout."

LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://iface/VSDK/docs/TIOVX-SYS-IFACE_1.0.0.0_manifest.html;md5=10904cbdb4f065c025a63ca71ae7de2d"

require recipes-ti/includes/arago-paths.inc
require tiovx-sys.inc

PR = "r1"

COMPATIBLE_MACHINE = "dra7xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit update-alternatives features_check

REQUIRED_MACHINE_FEATURES = "dsp"

SRC_URI:append = "\
     file://reload-dsp-fw.sh \
"

S = "${WORKDIR}/git"

do_install () {
#   Install the header files
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"
    install -d ${D}${TIOVX_INSTALL_DIR_RECIPE}/sys-iface
    cp ${CP_ARGS} ${S}/iface/VSDK/* ${D}${TIOVX_INSTALL_DIR_RECIPE}/sys-iface
#   Install the firmware
    install -d ${D}/${base_libdir}/firmware
    install -m 0644 ${S}/firmware/tiovx_dsp1.xe66 ${D}/${base_libdir}/firmware/dra7-dsp1-fw.xe66.openvx
    install -m 0644 ${S}/firmware/tiovx_dsp2.xe66 ${D}/${base_libdir}/firmware/dra7-dsp2-fw.xe66.openvx
#   Install the scripts for loading dsp firmware
    install -d ${D}${bindir}/
    install -m 0755 ${WORKDIR}/reload-dsp-fw.sh ${D}${bindir}
}

ALTERNATIVE:${PN} = "dra7-dsp1-fw.xe66 dra7-dsp2-fw.xe66"
ALTERNATIVE_LINK_NAME[dra7-dsp1-fw.xe66] = "${base_libdir}/firmware/dra7-dsp1-fw.xe66"
ALTERNATIVE_TARGET[dra7-dsp1-fw.xe66] = "${base_libdir}/firmware/dra7-dsp1-fw.xe66.openvx"
ALTERNATIVE_LINK_NAME[dra7-dsp2-fw.xe66] = "${base_libdir}/firmware/dra7-dsp2-fw.xe66"
ALTERNATIVE_TARGET[dra7-dsp2-fw.xe66] = "${base_libdir}/firmware/dra7-dsp2-fw.xe66.openvx"
ALTERNATIVE_PRIORITY = "20"

FILES:${PN} += "${TIOVX_INSTALL_DIR_RECIPE}/sys-iface/* "
PACKAGES =+ "${PN}-firmware"
FILES:${PN}-firmware = "${base_libdir}/firmware/*"

INSANE_SKIP:${PN}-firmware = "arch"
