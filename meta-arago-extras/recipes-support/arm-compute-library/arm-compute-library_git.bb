SUMMARY = "The ARM Computer Vision and Machine Learning library"
DESCRIPTION = "The ARM Computer Vision and Machine Learning library is a set of functions optimised for both ARM CPUs and GPUs."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e2c93841b20cd522af621cabaea3aef8"

COMPATIBLE_MACHINE = "armv7a"

SRC_URI = " \
    git://github.com/ARM-software/ComputeLibrary.git;branch=${BRANCH} \
"

PV  = "18.05"

BRANCH = "master"
SRCREV = "e2542c9f35ca427286822cd0c9296f49914f78b0"

S = "${WORKDIR}/git"

do_compile_prepend() {
    unset CC CXX
}

inherit scons

EXTRA_OESCONS = "arch=armv7a extra_cxx_flags="-fPIC" benchmark_tests=1 validation_tests=0 neon=1 openmp=1 opencl=0"

LIBS += "-larmpl_lp64_mp"

do_install() {
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"

    install -d ${D}${libdir}
    for lib in ${S}/build/*.so
    do
        install -m 0644 $lib ${D}${libdir}
    done

    # Install built source package as expected by ARMNN
    install -d ${D}${datadir}/${BPN}
    cp $CP_ARGS ${S}/. ${D}${datadir}/${BPN}
}

INSANE_SKIP_${PN}-dev = "dev-elf ldflags"

PACKAGES =+ "${PN}-source"
FILES_${PN}-source = "${datadir}/${BPN}"
INSANE_SKIP_${PN}-source = "ldflags libdir staticdev"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
