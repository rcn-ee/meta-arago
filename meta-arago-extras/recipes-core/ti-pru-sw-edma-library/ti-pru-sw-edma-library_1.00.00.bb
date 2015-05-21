DESCRIPTION = "eDMA library for use by PRU sw example applications"
HOMEPAGE = "https://gforge.ti.com/gf/project/pru_sw/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://edma.c;beginline=1;endline=46;md5=f6bde95a8e2277050e36b257ca9214a6"

DEPENDS += "virtual/kernel"

RDEPENDS_${PN} += "ti-pru-sw-edma-driver"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "omapl138"

MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"
PV_append = "+svn${SRCPV}"

SRC_URI = "svn://gforge.ti.com/svn/pru_sw/;module=trunk;protocol=https;user=anonymous;pswd=''"

SRCREV = "33"
S = "${WORKDIR}/trunk/peripheral_lib/edma_driver/interface"

do_compile () {
	oe_runmake KERNEL_DIR="${STAGING_KERNEL_DIR}" CCTOOL_PREFIX=${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}
}

do_install () {
	install -d ${D}/${libdir}
	install -m 0755 ${S}/../lib/libedmautils.a ${D}/${libdir}/
}
