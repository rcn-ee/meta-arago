SUMMARY = "ARM Neural Network SDK"
DESCRIPTION = "Linux software and tools to enable machine learning (Caffe/Tensorflow) workloads on power-efficient devices"
LICENSE = "MIT & Apache-2.0"
# Apache-2.0 license applies to mobilenet tarball
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e14a924c16f7d828b8335a59da64074 \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PR = "r4"
PV = "19.08"
PV_MAJOR = "${@d.getVar('PV',d,1).split('.')[0]}"

BRANCH = "branches/armnn_19_08"
SRCREV = "26052fcf2f8c91f3479c9484354e88e8944d004d"

SRCREV_tidl-api = "7e9a3942ec38efd64d45e34c10cba2f2938f5618"
BRANCH_tidl-api = "master"

SRCREV_FORMAT = "armnn"

S = "${WORKDIR}/git"

inherit cmake

SRC_URI = " \
    git://review.mlplatform.org/ml/armnn;protocol=https;name=armnn;branch=${BRANCH} \
    file://0001-stdlib-issue-work-around.patch \
    file://0002-enable-use-of-boost-shared-library.patch \
    file://0003-add-more-test-command-line-arguments.patch \
    file://0004-generate-versioned-library.patch \
    file://0005-add-armnn-mobilenet-test-example.patch \
    file://0006-armnn-mobilenet-test-example.patch \
    file://0007-enable-use-of-arm-compute-shared-library.patch \
    file://0009-command-line-options-for-video-port-selection.patch \
    file://0010-armnnexamples-update-for-19.08-modifications.patch \
    file://0011-Generate-versioned-library-for-armnnTfLiteParser.patch \
    file://0012-ArmnnExample-Fix-exception-for-help-command-line-opt.patch \
    file://0013-ArmnnExample-setting-capture-resolution-for-the-came.patch \
    http://download.tensorflow.org/models/mobilenet_v1_2018_02_22/mobilenet_v1_1.0_224.tgz;name=mobilenet;subdir=${WORKDIR}/tfmodel;destsuffix=tfmodel \
    https://storage.googleapis.com/mobilenet_v2/checkpoints/mobilenet_v2_1.0_224.tgz;name=mobilenetv2;subdir=${WORKDIR}/tfmodel;destsuffix=tfmodel \
    git://git.ti.com/tidl/tidl-api.git;name=tidl-api;branch=${BRANCH_tidl-api};subdir=${WORKDIR}/tidl-api;destsuffix=tidl-api \
"

SRC_URI[mobilenet.md5sum] = "d5f69cef81ad8afb335d9727a17c462a"
SRC_URI[mobilenet.sha256sum] = "1ccb74dbd9c5f7aea879120614e91617db9534bdfaa53dfea54b7c14162e126b"
SRC_URI[mobilenetv2.md5sum] = "519bba7052fd279c66d2a28dc3f51f46"
SRC_URI[mobilenetv2.sha256sum] = "318084bc1b63d6d7b854553e09cdf77078b1c0168be27c59a0d44253b5ed49dc"

DEPENDS = " \
    boost \
    protobuf \
    stb \
    arm-compute-library \
    armnn-caffe \
    armnn-tensorflow \
    armnn-onnx \
    tensorflow-lite \
    flatbuffers \
    opencv \
"

RDEPENDS_${PN} = " arm-compute-library protobuf boost "

EXTRA_OECMAKE=" \
    -DBUILD_SHARED_LIBS=ON -DREGISTER_INSTALL_PREFIX=OFF \
    -DARMCOMPUTE_ROOT=${STAGING_DIR_HOST}${datadir}/arm-compute-library \
    -DCAFFE_GENERATED_SOURCES=${STAGING_DIR_HOST}${datadir}/armnn-caffe \
    -DTF_GENERATED_SOURCES=${STAGING_DIR_HOST}${datadir}/armnn-tensorflow \
    -DONNX_GENERATED_SOURCES=${STAGING_DIR_HOST}${datadir}/armnn-onnx \
    -DBUILD_CAFFE_PARSER=1 -DBUILD_TF_PARSER=1 -DBUILD_ONNX_PARSER=1 -DBUILD_TF_LITE_PARSER=1 \
    -DTF_LITE_GENERATED_PATH=${STAGING_DIR_HOST}${includedir}/tensorflow/lite/schema \
    -DFLATBUFFERS_ROOT=${STAGING_DIR_HOST}${includedir}/flatbuffers \
    -DFLATBUFFERS_LIBRARY=${STAGING_DIR_HOST}${libdir}/libflatbuffers.so \
    -DARMCOMPUTENEON=1 \
    -DBUILD_TESTS=1 -DPROFILING=1 \
    -DTHIRD_PARTY_INCLUDE_DIRS=${STAGING_DIR_HOST}${includedir} \
    -DBUILD_ARMNN_EXAMPLES=1 \
    -DGENERIC_LIB_VERSION=${PV} -DGENERIC_LIB_SOVERSION=${PV_MAJOR} \
"

TESTVECS_INSTALL_DIR = "${datadir}/arm/armnn"

do_install_append() {
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"
    install -d ${D}${bindir}
    find ${WORKDIR}/build/tests -maxdepth 1 -type f -executable -exec cp $CP_ARGS {} ${D}${bindir} \;
    cp $CP_ARGS ${WORKDIR}/build/UnitTests  ${D}${bindir}
    install -d ${D}${TESTVECS_INSTALL_DIR}/models
    cp ${WORKDIR}/tfmodel/mobilenet_v1_1.0_224_frozen.pb  ${D}${TESTVECS_INSTALL_DIR}/models
    cp ${WORKDIR}/tfmodel/mobilenet_v2_1.0_224.tflite ${D}${TESTVECS_INSTALL_DIR}/models
    cp ${WORKDIR}/git/tests/TfMobileNet-Armnn/labels.txt  ${D}${TESTVECS_INSTALL_DIR}/models
    install -d ${D}${TESTVECS_INSTALL_DIR}/testvecs
    cp ${WORKDIR}/tidl-api/examples/classification/clips/*.mp4  ${D}${TESTVECS_INSTALL_DIR}/testvecs
    cp ${WORKDIR}/tidl-api/examples/classification/images/*.jpg  ${D}${TESTVECS_INSTALL_DIR}/testvecs
    chrpath -d ${D}${bindir}/*
}

CXXFLAGS += "-fopenmp"
LIBS += "-larmpl_lp64_mp"

FILES_${PN} += "${TESTVECS_INSTALL_DIR}"
FILES_${PN}-dev += "{libdir}/cmake/*"
INSANE_SKIP_${PN}-dev = "dev-elf"
