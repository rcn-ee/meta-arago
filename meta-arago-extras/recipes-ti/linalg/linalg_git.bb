DESCRIPTION = "TI Linear Algebra Library"

include linalg.inc
PR = "${INC_PR}.0"

TARGET_k2hk-evm = "SOC_K2H"
MEM_MODEL_k2hk-evm = "Large"
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile() {
   make ARMplusDSP MEM_MODEL=${MEM_MODEL} TARGET=${TARGET} LIBOS=LIB_OPENCL
   make docs
}

do_install() {
   make installARMplusDSPlib DESTDIR=${D}${LINALG_INSTALL_DIR_RECIPE}
}

# to create a package for LINALG
FILES_${PN}-dev += "${LINALG_INSTALL_DIR_RECIPE}"

INSANE_SKIP_${PN}-dev = "arch staticdev"
ALLOW_EMPTY_${PN} = "1"
