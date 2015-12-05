DESCRIPTION = "Firmware images to test IPC"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD;md5=3775480a712fc46a69647678acb234cb"

inherit update-alternatives

FWVER = "eng-4-gb9283b0"
PR = "r2+${FWVER}"

COMPATIBLE_MACHINE = "omap5-evm|dra7xx"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = "arch"

S = "${WORKDIR}/${PV}_${FWVER}"

SRC_URI = "http://arago-project.org/files/releases/ipc-test-fw/${PV}_${FWVER}.tar.gz"

SRC_URI[md5sum] = "4fcba6844949ea909131684a80233800"
SRC_URI[sha256sum] = "3b90b195c382937551251055aaa9185627e86027c91fb41a594dc390391d5fb6"

do_compile() {
    :
}

do_install() {
    install -d ${D}${base_libdir}/firmware
    for f in *.xe*
    do
        install -m 755 $f ${D}${base_libdir}/firmware/$f.${BPN}
    done
}

ALTERNATIVE_${PN} = "dra7-dsp1-fw.xe66 dra7-dsp2-fw.xe66 dra7-ipu1-fw.xem4 dra7-ipu2-fw.xem4 ducati-m3-core0.xem3 tesla-dsp.xe64T"
ALTERNATIVE_LINK_NAME[dra7-dsp1-fw.xe66] = "${base_libdir}/firmware/dra7-dsp1-fw.xe66"
ALTERNATIVE_TARGET[dra7-dsp1-fw.xe66] = "${base_libdir}/firmware/dra7-dsp1-fw.xe66.${BPN}"
ALTERNATIVE_LINK_NAME[dra7-dsp2-fw.xe66] = "${base_libdir}/firmware/dra7-dsp2-fw.xe66"
ALTERNATIVE_TARGET[dra7-dsp2-fw.xe66] = "${base_libdir}/firmware/dra7-dsp2-fw.xe66.${BPN}"
ALTERNATIVE_LINK_NAME[dra7-ipu1-fw.xem4] = "${base_libdir}/firmware/dra7-ipu1-fw.xem4"
ALTERNATIVE_TARGET[dra7-ipu1-fw.xem4] = "${base_libdir}/firmware/dra7-ipu1-fw.xem4.${BPN}"
ALTERNATIVE_LINK_NAME[dra7-ipu2-fw.xem4] = "${base_libdir}/firmware/dra7-ipu2-fw.xem4"
ALTERNATIVE_TARGET[dra7-ipu2-fw.xem4] = "${base_libdir}/firmware/dra7-ipu2-fw.xem4.${BPN}"
ALTERNATIVE_LINK_NAME[ducati-m3-core0.xem3] = "${base_libdir}/firmware/ducati-m3-core0.xem3"
ALTERNATIVE_TARGET[ducati-m3-core0.xem3] = "${base_libdir}/firmware/ducati-m3-core0.xem3.${BPN}"
ALTERNATIVE_LINK_NAME[tesla-dsp.xe64T] = "${base_libdir}/firmware/tesla-dsp.xe64T"
ALTERNATIVE_TARGET[tesla-dsp.xe64T] = "${base_libdir}/firmware/tesla-dsp.xe64T.${BPN}"
ALTERNATIVE_PRIORITY = "20"

FILES_${PN} += "${base_libdir}/firmware"
