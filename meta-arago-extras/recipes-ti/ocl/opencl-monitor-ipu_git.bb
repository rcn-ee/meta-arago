DESCRIPTION = "TI OpenCL M4/IPU device firmware for AM57x"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/opencl/intro.html"
LICENSE = "BSD"

include ocl.inc
require recipes-ti/includes/arago-paths.inc

PR = "${INC_PR}.0"

inherit cmake update-alternatives

DEPENDS = " common-csl-ip-rtos \
            pm-lld-rtos \
            ti-xdctools-native \
            ti-ipc-rtos \
            ti-sysbios \
            ti-pdk-build-rtos \
            ti-cgt-arm-native \
            util-linux-native \
            opencl-tidl-fw \
"

COMPATIBLE_MACHINE = "am57xx-evm|am57xx-hs-evm"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git/monitor_ipu"

BUILD_TARGET = "ARM_AM57"

EXTRA_OECMAKE += " -DCROSS_COMPILE=TRUE \
                   -DOCL_MONITOR_IPU_DIR=${S} \
                   -DBUILD_OUTPUT=all \
"

export IPC_DIR = "${IPC_INSTALL_DIR}"
export BIOS_DIR = "${SYSBIOS_INSTALL_DIR}"
export PDK_DIR = "${PDK_INSTALL_DIR}"
export XDC_DIR = "${XDC_INSTALL_DIR}"
export TI_OCL_M4_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/ti-cgt-arm"
export CSL_LIB_M4 = "${PDK_DIR}/packages/ti/csl/lib/am572x/m4/release/ti.csl.aem4"
export PM_HAL_LIB_M4 = "$(PDK_DIR)/packages/ti/drv/pm/lib/am572x/m4/release/pm_hal.aem4"
export OCL_TIDL_FW_DIR = "${OCL_TIDL_FW_INSTALL_DIR}"

ALTERNATIVE_${PN} = "dra7-ipu1-fw.xem4"
ALTERNATIVE_LINK_NAME[dra7-ipu1-fw.xem4] = "${base_libdir}/firmware/dra7-ipu1-fw.xem4"
ALTERNATIVE_TARGET[dra7-ipu1-fw.xem4] = "${base_libdir}/firmware/dra7-ipu1-fw.xem4.opencl-monitor"
ALTERNATIVE_PRIORITY = "100"

MONITOR_IPU_FIRMWARE = "${base_libdir}/firmware/dra7-ipu1-fw.*"

FILES_${PN} += " \
    ${MONITOR_IPU_FIRMWARE} \
"

INSANE_SKIP_${PN} = "arch"
