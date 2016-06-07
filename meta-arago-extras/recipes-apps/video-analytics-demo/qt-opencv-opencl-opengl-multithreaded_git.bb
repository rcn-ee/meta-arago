DESCRIPTION = "A simple multithreaded OpenCV example application using the Qt framework"
HOMEPAGE = "https://github.com/devernay/qt-opencv-multithreaded"
SECTION = "multimedia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=e28b998056a1a513e87be11c5045e85b"

DEPENDS += "opencv opencl virtual/egl ti-cgt6x-native clocl-native dsplib-c66x"

COMPATIBLE_MACHINE = "dra7xx"

PV = "1.3.3"
PR = "r1"

BRANCH = "master"
SRC_URI = "git://git.ti.com/apps/qt-opencv-opencl-opengl-multithreaded.git;protocol=git;branch=${BRANCH}"

SRCREV = "f679a74230dbf7ace66ef06f79e02ac9abfc7d58"

S = "${WORKDIR}/git"

inherit qt-provider

export TARGET_ROOTDIR = "${STAGING_DIR_HOST}"
export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export TI_DSPLIB_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/ti-dsplib-c66x-tree"

do_compile() {
    cd ${S}
    oe_runmake -f oclMakefile
    cd -
    oe_runmake
}

do_install() {
    install -d ${D}/usr/bin
    install -m 755 qt-opencv-opencl-opengl-multithreaded ${D}/usr/bin/qt-opencv-opencl-opengl-multithreaded
}

RDEPENDS_${PN} += "opencv opencl-runtime"
