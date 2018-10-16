SUMMARY = "The ARM Computer Vision and Machine Learning library"
DESCRIPTION = "The ARM Computer Vision and Machine Learning library is a set of functions optimised for both ARM CPUs and GPUs."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e2c93841b20cd522af621cabaea3aef8"

COMPATIBLE_MACHINE = "armv7a"

SRC_URI = " \
    git://github.com/ARM-software/ComputeLibrary.git;branch=${BRANCH} \
"

PV = "18.05"

BRANCH = "master"
SRCREV = "e2542c9f35ca427286822cd0c9296f49914f78b0"

S = "${WORKDIR}/git"

do_compile_prepend() {
    sed -i 's/arm-linux-gnueabihf-/${TOOLCHAIN_SYS}-/' SConstruct
    sed -i "s#env.Append(LINKFLAGS = \['-fopenmp'\])#env.Append(LINKFLAGS = \['-fopenmp','--sysroot=${STAGING_DIR_TARGET}'\])#" SConstruct
    unset CC CXX
}

inherit scons

EXTRA_OESCONS = "arch=armv7a extra_cxx_flags="-fPIC -Wno-unused-but-set-variable -Wno-ignored-qualifiers -Wno-noexcept ${TOOLCHAIN_OPTIONS}" benchmark_tests=1 validation_tests=0 neon=1 openmp=1 opencl=0"

LIBS += "-larmpl_lp64_mp"

do_install() {
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"

    install -m 0755 -d ${D}${libdir}
    for lib in ${S}/build/*.so
    do
        install -m 0755 $lib ${D}${libdir}
    done

    # Install 'example' and benchmark executables
    install -d ${D}${bindir}
    find ${S}/build/examples/ -maxdepth 1 -type f -executable -exec cp $CP_ARGS {} ${D}${bindir} \;
    cp $CP_ARGS ${S}/build/tests/arm_compute_benchmark ${D}${bindir}

    # Install built source package as expected by ARMNN
    install -d ${D}${datadir}/${BPN}
    cp $CP_ARGS ${S}/. ${D}${datadir}/${BPN}
}

SOLIBS = ".so"
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "dev-elf ldflags"

PACKAGES =+ "${PN}-source"
FILES_${PN} += "${bindir}/*"
FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-source = "${datadir}/${BPN}"
INSANE_SKIP_${PN}-source = "ldflags libdir staticdev"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
