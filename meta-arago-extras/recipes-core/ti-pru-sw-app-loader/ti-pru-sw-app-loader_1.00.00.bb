DESCRIPTION = "PRU sw application loader"
HOMEPAGE = "https://gforge.ti.com/gf/project/pru_sw/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://interface/prussdrv.c;beginline=1;endline=47;md5=6012fea45c1fbced663277bc90d2163a"

RRECOMMENDS_${PN} = "kernel-module-uio-pru"
PR = "r0+svnr${SRCPV}"

COMPATIBLE_MACHINE = "omapl138"

SRC_URI = "svn://gforge.ti.com/svn/pru_sw/;module=trunk;protocol=https;user=anonymous;pswd=''"

SRCREV = "33"
S = "${WORKDIR}/trunk/app_loader"

do_compile () {
        make -C ${S}/interface CCTOOL_PREFIX=${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}
}

do_install () {
        install -d ${D}${libdir}
        install -d ${D}${includedir}
        install -m 0644 ${S}/include/* ${D}${includedir}
        install -m 0644 ${S}/lib/* ${D}${libdir}
}
