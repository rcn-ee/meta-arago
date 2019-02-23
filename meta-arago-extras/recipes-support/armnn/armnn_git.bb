SUMMARY = "ARM Neural Network SDK"
DESCRIPTION = "Linux software and tools to enable machine learning (Caffe/Tensorflow) workloads on power-efficient devices"
LICENSE = "MIT & Apache-2.0"
# Apache-2.0 license applies to mobilenet tarball
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e14a924c16f7d828b8335a59da64074 \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PR = "r0"
PV = "19.02"
PV_MAJOR = "${@d.getVar('PV',d,1).split('.')[0]}"

BRANCH = "master"
SRCREV = "0028d1b0ce5f4c2c6a6eb3c66f38111c21eb47a3"
SRCREV_tidl-api = "7e9a3942ec38efd64d45e34c10cba2f2938f5618"

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
    http://download.tensorflow.org/models/mobilenet_v1_2018_02_22/mobilenet_v1_1.0_224.tgz;name=mobilenet;subdir=${WORKDIR}/tfmodel;destsuffix=tfmodel \
    git://git.ti.com/tidl/tidl-api.git;name=tidl-api;branch=${BRANCH};subdir=${WORKDIR}/tidl-api;destsuffix=tidl-api \
"

SRC_URI[mobilenet.md5sum] = "d5f69cef81ad8afb335d9727a17c462a"
SRC_URI[mobilenet.sha256sum] = "1ccb74dbd9c5f7aea879120614e91617db9534bdfaa53dfea54b7c14162e126b"

DEPENDS = " \
    boost \
    protobuf \
    stb \
    arm-compute-library \
    armnn-caffe \
    armnn-tensorflow \
    armnn-onnx \
    opencv \
"

RDEPENDS_${PN} = " arm-compute-library protobuf boost "

EXTRA_OECMAKE=" \
    -DBUILD_SHARED_LIBS=ON -DREGISTER_INSTALL_PREFIX=OFF \
    -DARMCOMPUTE_ROOT=${STAGING_DIR_HOST}${datadir}/arm-compute-library \
    -DCAFFE_GENERATED_SOURCES=${STAGING_DIR_HOST}${datadir}/armnn-caffe \
    -DTF_GENERATED_SOURCES=${STAGING_DIR_HOST}${datadir}/armnn-tensorflow \
    -DONNX_GENERATED_SOURCES=${STAGING_DIR_HOST}${datadir}/armnn-onnx \
    -DBUILD_CAFFE_PARSER=1 -DBUILD_TF_PARSER=1 -DBUILD_ONNX_PARSER=1 \
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
