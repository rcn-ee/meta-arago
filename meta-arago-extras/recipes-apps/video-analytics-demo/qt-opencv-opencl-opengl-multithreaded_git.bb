DESCRIPTION = "A simple multithreaded OpenCV example application using the Qt framework"
HOMEPAGE = "https://github.com/devernay/qt-opencv-multithreaded"
SECTION = "multimedia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=e28b998056a1a513e87be11c5045e85b"

inherit features_check

REQUIRED_MACHINE_FEATURES = "dsp"
REQUIRED_DISTRO_FEATURES = "opencv opencl opengl"

DEPENDS += "opencv opencl virtual/egl ti-cgt6x-native clocl-native dsplib-c66x"

COMPATIBLE_MACHINE = "dra7xx"

PV = "1.3.3"
PR = "r3"

BRANCH = "master"
SRC_URI = "git://git.ti.com/apps/qt-opencv-opencl-opengl-multithreaded.git;protocol=git;branch=${BRANCH}"

SRCREV = "80051ec8befd921e40cfb74a49234ed045576bbc"

S = "${WORKDIR}/git"

inherit qt5

export TARGET_ROOTDIR = "${STAGING_DIR_HOST}"
export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export TI_DSPLIB_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/ti-dsplib-c66x-tree"

CXXFLAGS:append = " -DOCV_NATIVE "

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

RDEPENDS:${PN} += "opencv opencl-runtime"
