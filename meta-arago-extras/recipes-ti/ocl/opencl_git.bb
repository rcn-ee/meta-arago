DESCRIPTION = "TI OpenCL host runtime and development packages"
HOMEPAGE = "https://downloads.ti.com/mctools/esd/docs/opencl/index.html"
LICENSE = "BSD"

include ocl.inc

PR = "${INC_PR}.3"

inherit cmake systemd

COMPATIBLE_MACHINE = "dra7xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

# Define runtime package for minimal dependencies to run opencl applications
# which precompile the offloaded kernels. The base package will provide the
# ability to compile kernels (clocl) during runtime.
PACKAGES =+ "${PN}-runtime"

MONITORS                      = " opencl-monitor"
MONITORS:append:dra7xx        = " opencl-monitor-ipu"

DEPENDS = " ocl-gl-headers \
            ${MONITORS} \
            cmake-native \
            cmem \
            ti-llvm3.6 \
            ti-llvm3.6-native \
            binutils \
            sqlite3 \
            libffi \
            boost \
            boost-native \
            libloki \
            pkgconfig-native \
            libulm \
            elfutils \
            json-c \
"

DEPENDS:append:dra7xx = " ti-ipc virtual/kernel"

RDEPENDS:${PN}-runtime += "bash ${MONITORS}"
RDEPENDS:${PN}-dev += "ocl-gl-headers-dev"
RDEPENDS:${PN} += "${PN}-runtime clocl bash"

# Use main package to pull in full support
ALLOW_EMPTY:${PN} = "1"

S = "${WORKDIR}/git/host"

export WANT_LLVM_RELEASE = "3.6-ti"

OCL_BUILD_TARGET:dra7xx = "ARM_AM57"

ENABLE_ULM = "1"
SHMEM_MANAGER = "CMEM"

EXTRA_OECMAKE += " -DBUILD_TARGET=${OCL_BUILD_TARGET} -DBUILD_OUTPUT=lib -DENABLE_ULM=${ENABLE_ULM} -DOCL_VERSION=${PV} -DSHMEM_MANAGER=${SHMEM_MANAGER}"

EXTRA_OEMAKE += "KERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR} LINUX_DEVKIT_ROOT=${STAGING_DIR_HOST}"
export KERNEL_INSTALL_DIR = "${STAGING_KERNEL_DIR}"

MCTD = ""
MCTD:dra7xx = "${S}/mct-daemon/ti-mct-daemon.service.am57x"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m0644 ${MCTD} ${D}${systemd_system_unitdir}/ti-mct-daemon.service
}

SYSTEMD_PACKAGES = "${PN}-runtime"
SYSTEMD_SERVICE:${PN}-runtime = "ti-mct-daemon.service"
SYSTEMD_AUTO_ENABLE:${PN}-runtime = "${@oe.utils.conditional("RESERVE_CMEM", "1", "enable", "disable", d)}"

FILES:${PN}-runtime += "${bindir} ${systemd_system_unitdir} ${sysconfdir}/ti-mctd ${libdir}/lib*${SOLIBS}"

FILES:${PN} += " \
    ${datadir}/ti/opencl/* \
"
