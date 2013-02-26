DESCRIPTION = "PRU sw example applications"
HOMEPAGE = "https://gforge.ti.com/gf/project/pru_sw/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENCE.txt;md5=c4fd8ee7443c1b2b6238b4b5df796481"
DEPENDS = "ti-pru-sw-app-loader ti-pru-sw-edma-library"
RDEPENDS_${PN} = "ti-pru-sw-edma-driver"
PR = "r0+svnr${SRCPV}"

COMPATIBLE_MACHINE = "am180x-evm"

SRC_URI = "svn://gforge.ti.com/svn/pru_sw/;module=trunk;protocol=https;user=anonymous;pswd=''"

SRCREV = "33"
S = "${WORKDIR}/trunk"

do_compile () {
        make -C ${S}/example_apps \
          CCTOOLS="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"\
          BINDIR_APPLICATIONS="${S}/example_apps/bin" \
          BINDIR_FW="${S}/example_apps/bin" \
          UTILS_DIR="${S}/utils"
}

do_install () {
        install -d ${D}/usr/share/ti/ti-pru-eg/
        install -m 0755 ${S}/example_apps/bin/* ${D}/usr/share/ti/ti-pru-eg/
}

FILES_${PN} += "${datadir}/ti/ti-pru-eg/*"
FILES_${PN}-dbg += "${datadir}/ti/ti-pru-eg/.debug/*"
