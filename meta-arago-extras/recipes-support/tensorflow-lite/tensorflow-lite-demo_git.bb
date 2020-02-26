DESCRIPTION = "Tensorflow Lite Demo with input and display via OpenCV and TIDL acceleration for AM5"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8927f3331d2b3e321b7dd1925166d25"

DEPENDS = "tensorflow-lite flatbuffers opencv"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|am65xx"

PV = "01.00.00"
PR = "r0"

BRANCH = "master"
SRC_URI  = "git://git.ti.com/apps/tensorflow-lite-examples.git;protocol=git;branch=${BRANCH} \
            http://storage.googleapis.com/download.tensorflow.org/models/tflite/gpu/deeplabv3_257_mv_gpu.tflite;name=deeplabv3;subdir=${WORKDIR}/model;destsuffix=model \
            http://raw.githubusercontent.com/google-coral/edgetpu/master/test_data/bird_segmentation.bmp;name=bird_segmentation;subdir=${WORKDIR}/test_data;destsuffix=test_data \
            file://run_classification.sh \
            file://run_segmentation.sh"

SRC_URI[deeplabv3.md5sum] = "4a24db5a5fb05c47586a1197765e8548"
SRC_URI[deeplabv3.sha256sum] = "68a539782c2c6a72f8aac3724600124a85ed977162b44e84cbae5db717c933c6"
SRC_URI[bird_segmentation.md5sum] = "fc3202ac4e3033b36df3043de6dc32c9"
SRC_URI[bird_segmentation.sha256sum] = "e43cedd29ab385db787531c8a6cdcb31c5e4292af34f242877ed40611e502670"

SRCREV = "d84f1d43585c0db2fa6a1c15db9145ab53f859ce"

S = "${WORKDIR}/git"

CXXFLAGS_append = " -O3 -DNDEBUG -fPIC -I${STAGING_INCDIR}"
LDFLAGS_append = " -L${STAGING_LIBDIR}"

EXTRA_OEMAKE = "\
    'CXX=${CXX}' \
    'CXXFLAGS=${CXXFLAGS}' \
    'AR=${AR}' \
    'LD=${LD}' \
    'LDFLAGS=${LDFLAGS}' \
    'TARGET=${TARGET_OS}' \
    'TARGET_ARCH=${TARGET_ARCH}'"

do_compile() {
    oe_runmake -f Makefile
}

do_install() {
    install -d ${D}${datadir}/tensorflow-lite/demos
    install -m 0755 ${S}/tflite_classification ${D}${datadir}/tensorflow-lite/demos
    install -m 0755 ${S}/tflite_segmentation ${D}${datadir}/tensorflow-lite/demos
    install -m 0644 ${WORKDIR}/model/deeplabv3_257_mv_gpu.tflite ${D}${datadir}/tensorflow-lite/demos
    install -m 0644 ${WORKDIR}/test_data/bird_segmentation.bmp ${D}${datadir}/tensorflow-lite/demos
    install -m 0755 ${WORKDIR}/run*.sh ${D}${datadir}/tensorflow-lite/demos
}

FILES_${PN} = "${datadir}/tensorflow-lite/demos"
