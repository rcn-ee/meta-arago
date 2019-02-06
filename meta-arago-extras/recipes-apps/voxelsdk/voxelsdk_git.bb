SUMMARY = "VOXELSDK and 3D scanning application"
HOMEPAGE = "https://github.com/3dtof/voxelsdk"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e69c599445026ffeae140a21181dfa88"

PV = "0.6.8"
PR = "r1"
BRANCH = "plsdk-devel"
SRC_URI = "git://github.com/3dtof/voxelsdk.git;branch=${BRANCH}"
SRCREV  = "7337ac265a1542f22ccffe592762c226b23b2dbd"

SRC_URI += " \
            file://0001-PLSDK-AM437x-update.patch;patchdir=${S} \
            file://0002-Fix-SWIG-support.patch;patchdir=${S} \
            file://0003-Add-more-command-line-options-and-move-OpenCV-render.patch;patchdir=${S} \
            file://0004-Platform-specific-op_clk_freq-setting.patch;patchdir=${S} \
            file://0005-Exit-on-window-touch-mouse-even-left-button-click.patch;patchdir=${S} \
            file://0006-Include-people-count-report-in-stdout-for-testing.patch;patchdir=${S} \
           "

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

export CMAKE_PREFIX_PATH="${WORKDIR}/build"

OPCLK = "SET_OPCLK"
OPCLK_ti43x = "RESET_OPCLK"
CXXFLAGS_append = " -I${STAGING_INCDIR}/libusb-1.0 -D${OPCLK}"
EXTRA_OECMAKE += "-DDISTROFEATURE=ExcludePCL -DCMAKE_BUILD_TYPE=Debug -DPYTHON_INCLUDE_DIRS=${STAGING_INCDIR}/include/python2.7"

inherit pkgconfig cmake pythonnative python-dir

DEPENDS = "libusb1 udev opencv boost python python-dev swig swig-native"

RDEPENDS_${PN} = "libusb1 udev opencv"

do_install_append () {
    install -d ${D}${bindir}
    install -m 0775 ${S}/Test/CameraSystemTest.py ${D}${bindir}
    install -m 0775 ${S}/Test/CameraSystemIQFrameTest.py ${D}${bindir}
    install -m 0775 ${S}/Test/LensCalibrationTest.py ${D}${bindir}
}

FILES_${PN} += "${datadir}"
FILES_${PN} += "${sysconfdir}/udev/rules.d/*"
FILES_${PN} += "${libdir}/voxel/*.so.*"
FILES_${PN} += "${libdir}/python2.7/_*.so"
FILES_${PN} += "${libdir}/python2.7/*.py"

FILES_${PN}-dev += "${libdir}/cmake ${libdir}/cmake/Voxel ${libdir}/cmake/TI3DToF"
FILES_${PN}-dev += "${libdir}/cmake/Voxel/*.cmake"
FILES_${PN}-dev += "${libdir}/cmake/TI3DToF/*.cmake"
FILES_${PN}-dev += "${libdir}/voxel/*.so"
