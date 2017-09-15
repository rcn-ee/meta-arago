PR = "r3"

BRANCH = "tiopencvrelease_3.1"

SRC_URI_remove = "git://github.com/Itseez/opencv.git;name=opencv"
SRC_URI_prepend = "git://git.ti.com/opencv/tiopencv.git;protocol=git;branch=${BRANCH};name=opencv"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "\
     file://setupEnv.sh \
"

SRCREV_opencv = "4458601eb2766461f2f9da0d2527ff25ecb20284"

DEPENDS_remove_keystone = "qtbase"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGECONFIG_QTWAYLAND = "${@bb.utils.contains("DISTRO_FEATURES", "wayland", "qtwayland", "", d)}"
PACKAGECONFIG_QTWAYLAND_keystone = ""

PACKAGECONFIG_append = " ${PACKAGECONFIG_QTWAYLAND} \
                         ${@bb.utils.contains('MACHINE_FEATURES','dsp','opencl', '', d)} \
"

inherit cmake_qt5

PACKAGECONFIG[opencl] = "-DWITH_OPENCL=ON -DCMAKE_CXX_FLAGS_RELEASE="${CMAKE_CXX_FLAGS_RELEASE} -DCV_TIOPENCL -DCV_TIOPENCL_ENABLE_PROGRAM_COUNT -DMAX_PROGRAM_HASH_SIZE=50" -DCMAKE_C_FLAGS_RELEASE="${CMAKE_C_FLAGS_RELEASE} -DCV_TIOPENCL -DCV_TIOPENCL_ENABLE_PROGRAM_COUNT -DMAX_PROGRAM_HASH_SIZE=50" -DWITH_OPENCLAMDFFT=OFF -DWITH_OPENCLAMDBLAS=OFF,-DWITH_OPENCL=OFF,cmem opencl,"
PACKAGECONFIG[qtwayland] = "-DWITH_QT=ON,-DWITH_QT=OFF,qtwayland,"

do_install_append() {
    install -d ${D}${datadir}/OpenCV/samples/bin/
    install -d ${D}${datadir}/OpenCV/titestsuite/
    cp -f bin/*_test_* ${D}${datadir}/OpenCV/samples/bin/
    cp -f ${S}/titestsuite/* ${D}${datadir}/OpenCV/titestsuite/
    cp -f ${WORKDIR}/setupEnv.sh ${D}${datadir}/OpenCV/titestsuite/
}
