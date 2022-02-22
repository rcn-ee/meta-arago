DESCRIPTION = "TI Linear Algebra Library"

include linalg.inc
PR = "${INC_PR}.0"

TARGET:dra7xx        = "SOC_AM572x"
MEM_MODEL:dra7xx     = "Small"
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile() {
	make -f build/Makefile MEM_MODEL=${MEM_MODEL} TARGET=${TARGET} LIBOS=LIB_OPENCL PARALLEL_MAKE="${PARALLEL_MAKE}"
}

do_install() {
	install -d ${D}${LINALG_INSTALL_DIR_RECIPE}
	cp -r exports/linalg_${PV}/* ${D}${LINALG_INSTALL_DIR_RECIPE}
}

# to create a package for LINALG
FILES:${PN}-dev += "${LINALG_INSTALL_DIR_RECIPE}"

INSANE_SKIP:${PN}-dev = "arch staticdev"
ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN}-dev += "bash perl"
