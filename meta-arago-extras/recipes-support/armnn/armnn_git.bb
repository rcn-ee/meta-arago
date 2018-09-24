SUMMARY = "ARM Neural Network SDK"
DESCRIPTION = "Linux software and tools to enable machine learning (Caffe/Tensorflow) workloads on power-efficient devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3e14a924c16f7d828b8335a59da64074"

PV = "20180502"

BRANCH = "master"
SRCREV = "4c7098bfeab1ffe1cdc77f6c15548d3e73274746"

S = "${WORKDIR}/git"

inherit cmake

SRC_URI = " \
    git://github.com/ARM-software/armnn.git;branch=${BRANCH} \
    file://0001-stdlib-issue-work-around.patch \
    file://0002-enable-use-of-boost-shared-library.patch \
"

DEPENDS = " \
    boost \
    protobuf \
    stb \
    arm-compute-library \
    armnn-caffe \
    armnn-tensorflow \
"

RDEPENDS_${PN} = " arm-compute-library protobuf boost "

EXTRA_OECMAKE=" \
    -DBUILD_SHARED_LIBS=ON -DREGISTER_INSTALL_PREFIX=OFF \
    -DARMCOMPUTE_ROOT=${STAGING_DIR_HOST}${datadir}/arm-compute-library \
    -DARMCOMPUTE_BUILD_DIR=${STAGING_DIR_HOST}${datadir}/arm-compute-library/build \
    -DCAFFE_GENERATED_SOURCES=${STAGING_DIR_HOST}${datadir}/armnn-caffe \
    -DTF_GENERATED_SOURCES=${STAGING_DIR_HOST}${datadir}/armnn-tensorflow \
    -DBUILD_CAFFE_PARSER=1 -DBUILD_TF_PARSER=1 \
    -DARMCOMPUTENEON=1 \
    -DBUILD_TESTS=1 -DPROFILING=1 \
    -DTHIRD_PARTY_INCLUDE_DIRS=${STAGING_DIR_HOST}${includedir} \
"

do_install_append() {
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"
    install -d ${D}${bindir}
    find ${WORKDIR}/build/tests -maxdepth 1 -type f -executable -exec cp $CP_ARGS {} ${D}${bindir} \;
    cp $CP_ARGS ${WORKDIR}/build/UnitTests  ${D}${bindir}
    chrpath -d ${D}${bindir}/*
}

CXXFLAGS += "-fopenmp"
LIBS += "-larmpl_lp64_mp"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""
FILES_${PN} += "{bindir}/*"
FILES_${PN} += "{libdir}/*"
FILES_${PN}-dev += "{libdir}/cmake/*"
INSANE_SKIP_${PN}-dev = "dev-elf"
