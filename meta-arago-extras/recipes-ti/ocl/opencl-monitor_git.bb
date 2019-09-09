DESCRIPTION = "TI OpenCL compute device firmware"
HOMEPAGE = "https://downloads.ti.com/mctools/esd/docs/opencl/index.html"
LICENSE = "BSD"

include ocl.inc
require recipes-ti/includes/arago-paths.inc

PR = "${INC_PR}.0"

inherit update-alternatives

DEPENDS = " ti-llvm3.6-native \
            common-csl-ip-rtos \
            ti-xdctools-native \
            ti-ipc-rtos \
            ti-sysbios \
            ti-cgt6x-native \
            edma3-lld-rtos \
            ti-xdais \
            ti-framework-components \
            libulm \
            gdbserver-c6x \
            libaet \
            openmp-rtos \
"

DEPENDS_append_k2hk = " multiprocmgr-rtos \
                            qmss-lld-rtos \
                            cppi-lld-rtos \
                            rm-lld-rtos \
"

DEPENDS_append_k2l  = " multiprocmgr-rtos \
                            qmss-lld-rtos \
                            cppi-lld-rtos \
                            rm-lld-rtos \
"

DEPENDS_append_k2e  = " multiprocmgr-rtos \
                            qmss-lld-rtos \
                            cppi-lld-rtos \
                            rm-lld-rtos \
"

DEPENDS_append_dra7xx = " opencl-tidl-fw \
"

COMPATIBLE_MACHINE = "dra7xx|keystone"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git/monitor"

BUILD_TARGET_dra7xx = "ARM_AM57"
BUILD_TARGET_k2hk = "ARM_K2H"
BUILD_TARGET_k2l = "ARM_K2L"
BUILD_TARGET_k2e = "ARM_K2E"
BUILD_TARGET_k2g = "ARM_K2G"

export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export PDK_DIR = "${PDK_INSTALL_DIR}"
export IPC_DIR = "${IPC_INSTALL_DIR}"
export XDC_DIR = "${XDC_INSTALL_DIR}"
export BIOS_DIR = "${SYSBIOS_INSTALL_DIR}"
export EDMA3LLD_DIR = "${EDMA3_LLD_INSTALL_DIR}"
export XDAIS_DIR = "${XDAIS_INSTALL_DIR}"
export FC_DIR = "${FC_INSTALL_DIR}"
export MPM_DIR = "${MPM_INSTALL_DIR}"
export OMP_DIR = "${OMP_INSTALL_DIR}"
export ULM_DIR ="${STAGING_DIR_TARGET}/usr/share/ti/ulm"
export GDB_SERVER_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/gdbc6x"
export AET_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/ctoolslib/aet"
export X86_LLVM_DIR = "${STAGING_DIR_NATIVE}/usr"
export XDCPATH = "${S};${IPC_DIR}/packages;${BIOS_DIR}/packages;${EDMA3LLD_DIR}/packages;${FC_DIR}/packages;${XDAIS_DIR}/packages"
export OCL_TIDL_FW_DIR = "${OCL_TIDL_FW_INSTALL_DIR}"
export OCL_FPERMS = "664"
export OCL_DPERMS = "775"
export SHARE_PATH="${D}${datadir}/ti/opencl"

EXTRA_OEMAKE += " BUILD_OS=linux \
                  WORKING_DIRECTORY=${S} \
                  BUILD_TARGET=${BUILD_TARGET} \
"
do_compile() {
  oe_runmake -f Makefile
}

do_install() {
    install -m ${OCL_DPERMS} -d ${SHARE_PATH}
}

install_dsp_objs() {
    install -m ${OCL_FPERMS} monitor_${1}/dsp0.out ${SHARE_PATH}/dsp.out
    install -m ${OCL_FPERMS} monitor_${1}/dsp0.syms.obj ${SHARE_PATH}/dsp_syms.obj
    install -m ${OCL_FPERMS} monitor_${1}/dsp0.syms ${SHARE_PATH}/dsp.syms
}

do_install_append_dra7xx() {
    install_dsp_objs am57x
    install -m ${OCL_DPERMS} -d ${D}${base_libdir}/firmware
    install -m ${OCL_FPERMS} monitor_am57x/dsp0.out ${D}${base_libdir}/firmware/dra7-dsp1-fw.xe66.${BPN}
    install -m ${OCL_FPERMS} monitor_am57x/dsp1.out ${D}${base_libdir}/firmware/dra7-dsp2-fw.xe66.${BPN}
}

do_install_append_k2hk() {
    for i in {0..7}; do install -m ${OCL_FPERMS} monitor_evmk2h/dsp${i}.out ${SHARE_PATH}; done
    install_dsp_objs evmk2h
}

do_install_append_k2l() {
    for i in {0..3}; do install -m ${OCL_FPERMS} monitor_evmk2l/dsp${i}.out ${SHARE_PATH}; done
    install_dsp_objs evmk2l
}

do_install_append_k2e() {
    install -m ${OCL_FPERMS} monitor_evmk2e/dsp0.out ${SHARE_PATH}
    install_dsp_objs evmk2e
}

do_install_append_k2g() {
    install -m ${OCL_FPERMS} monitor_evmk2g/dsp0.out ${SHARE_PATH}
    install -m ${OCL_FPERMS} monitor_evmk2g/dsp0.out ${SHARE_PATH}/dsp.out
    install -m ${OCL_FPERMS} monitor_evmk2g/dsp.syms ${SHARE_PATH}
    install -m ${OCL_FPERMS} monitor_evmk2g/dsp_syms.obj ${SHARE_PATH}
}

ALTERNATIVE_${PN}_dra7xx = "dra7-dsp1-fw.xe66 dra7-dsp2-fw.xe66"
ALTERNATIVE_LINK_NAME[dra7-dsp1-fw.xe66] = "${base_libdir}/firmware/dra7-dsp1-fw.xe66"
ALTERNATIVE_TARGET[dra7-dsp1-fw.xe66] = "${base_libdir}/firmware/dra7-dsp1-fw.xe66.${BPN}"
ALTERNATIVE_LINK_NAME[dra7-dsp2-fw.xe66] = "${base_libdir}/firmware/dra7-dsp2-fw.xe66"
ALTERNATIVE_TARGET[dra7-dsp2-fw.xe66] = "${base_libdir}/firmware/dra7-dsp2-fw.xe66.${BPN}"
ALTERNATIVE_PRIORITY = "100"

MONITOR_FIRMWARE = ""
MONITOR_FIRMWARE_dra7xx = "${base_libdir}/firmware/*"

FILES_${PN} += " \
    ${datadir}/ti/opencl/* \
    ${MONITOR_FIRMWARE} \
"

INSANE_SKIP_${PN} = "arch"
