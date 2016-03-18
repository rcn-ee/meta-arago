DESCRIPTION = "ARM HEVC Decoder with Unit Test Application"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_multimedia/"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM := "file://Inc/exp_pp_h265decoder.h;beginline=1;endline=27;md5=51a0ae5cca603a21186bf6ff458f3be9"
PR = "r2"

COMPATIBLE_MACHINE = "dra7xx|keystone"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/1280/7770/REL.HEVC.D.ARM.OBJ.${PV}.tar.gz;name=hevc-arm-decoder"

SRC_URI[hevc-arm-decoder.md5sum] = "bb7620e34175f53a1ed989f7ce8f6d29"
SRC_URI[hevc-arm-decoder.sha256sum] = "e5743478e94bcfcee2e59e2e0056ece648c11bcbac91a6a8b8e492e3b42738d4"

S = "${WORKDIR}/HEVC.D.ARM.${PV}/ARM_001"

SRC_URI_append = " file://Testparams.cfg"

do_compile() {
    cd ${S}/Client/Build/ARM
    make
}

do_install() {
    install -d ${D}${libdir}
    install -m 755 ${S}/Lib/h265vdec_pp_lib.a ${D}${libdir}

    install -d ${D}${includedir}
    install -m 644 ${S}/Inc/exp_pp_h265decoder.h ${D}${includedir}

    install -d ${D}${bindir}
    install -m 755 ${S}/Client/Build/ARM/Out/h265vdec_pp ${D}${bindir}

    install -d ${D}${datadir}/ti/examples/h265vdec
    install -m 644 ${WORKDIR}/Testparams.cfg ${D}${datadir}/ti/examples/h265vdec

    install -d ${D}${docdir}/${PN}
    for doc in ${S}/Docs/*; do
        install -m 664 ${doc} ${D}${docdir}/${PN}
    done
}

FILES_${PN} += "\
    ${datadir}/ti/*  \
"
