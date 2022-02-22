SUMMARY = "Tensorflow Lite Demo with input and display via OpenCV and TIDL acceleration for AM5"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8927f3331d2b3e321b7dd1925166d25"

inherit features_check

REQUIRED_DISTRO_FEATURES = "opencv"
REQUIRED_DISTRO_FEATURES:append:dra7xx = " opencl"

DEPENDS = "tensorflow-lite flatbuffers opencv"
DEPENDS:append:dra7xx = " tidl-api"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|am65xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "01.00.00"
PR = "r1"

BRANCH = "master"
SRC_URI  = "git://git.ti.com/apps/tensorflow-lite-examples.git;protocol=git;branch=${BRANCH} \
            http://storage.googleapis.com/download.tensorflow.org/models/tflite/gpu/deeplabv3_257_mv_gpu.tflite;name=deeplabv3;subdir=${WORKDIR}/model;destsuffix=model \
            http://storage.googleapis.com/download.tensorflow.org/models/mobilenet_v1_2018_02_22/mobilenet_v1_1.0_224.tgz;name=mobilenetv1;subdir=${WORKDIR}/model;destsuffix=model \
            http://raw.githubusercontent.com/google-coral/edgetpu/master/test_data/bird_segmentation.bmp;name=bird_segmentation;subdir=${WORKDIR}/test_data;destsuffix=test_data"

SRC_URI[deeplabv3.md5sum] = "4a24db5a5fb05c47586a1197765e8548"
SRC_URI[deeplabv3.sha256sum] = "68a539782c2c6a72f8aac3724600124a85ed977162b44e84cbae5db717c933c6"
SRC_URI[mobilenetv1.md5sum] = "d5f69cef81ad8afb335d9727a17c462a"
SRC_URI[mobilenetv1.sha256sum] = "1ccb74dbd9c5f7aea879120614e91617db9534bdfaa53dfea54b7c14162e126b"
SRC_URI[bird_segmentation.md5sum] = "fc3202ac4e3033b36df3043de6dc32c9"
SRC_URI[bird_segmentation.sha256sum] = "e43cedd29ab385db787531c8a6cdcb31c5e4292af34f242877ed40611e502670"

SRCREV = "bd6a429c21f96d5112e0b6dea44a13b748eefd74"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "\
    'CXX=${CXX}' \
    'CXXFLAGS=${CXXFLAGS}' \
    'AR=${AR}' \
    'LD=${LD}' \
    'LDFLAGS=${LDFLAGS}' \
    'TARGET=${TARGET_OS}' \
    'TARGET_ARCH=${TARGET_ARCH}'"

EXTRA_OEMAKE += "SYSROOT_INCDIR="${STAGING_INCDIR}" SYSROOT_LIBDIR="${STAGING_LIBDIR}" \
                 TIDL_API_DIR="${STAGING_DATADIR}/ti/tidl""

TIDL = "no"
TIDL:dra7xx = "yes"
do_compile() {
    oe_runmake -f Makefile TIDL_ACC=${TIDL}
}

do_install() {
    install -d ${D}${datadir}/tensorflow-lite/demos
    install -m 0755 ${S}/tflite_classification ${D}${datadir}/tensorflow-lite/demos
    install -m 0755 ${S}/tflite_segmentation ${D}${datadir}/tensorflow-lite/demos
    install -m 0644 ${WORKDIR}/model/deeplabv3_257_mv_gpu.tflite ${D}${datadir}/tensorflow-lite/demos
    install -m 0644 ${WORKDIR}/model/mobilenet_v1_1.0_224.tflite ${D}${datadir}/tensorflow-lite/demos
    install -m 0644 ${WORKDIR}/test_data/bird_segmentation.bmp ${D}${datadir}/tensorflow-lite/demos
    install -m 0755 ${S}/scripts/run*.sh ${D}${datadir}/tensorflow-lite/demos
}

FILES:${PN} = "${datadir}/tensorflow-lite/demos"
