SUMMARY = "ARM HEVC Decoder with Unit Test Application"
HOMEPAGE = "https://git.ti.com/processor-sdk/hevc_arm_decoder/"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://Inc/exp_pp_h265decoder.h;beginline=1;endline=27;md5=51a0ae5cca603a21186bf6ff458f3be9"
PR = "r4"

COMPATIBLE_MACHINE = "dra7xx|keystone"

BRANCH = "master"

SRC_URI = "git://git.ti.com/processor-sdk/hevc_arm_decode.git;protocol=git;branch=${BRANCH} \
           file://Testparams.cfg \
"

SRCREV = "4004c553e672538d0c3b5fa2ea0490ec095d0060"

PV = "01.00.00.01"

S = "${WORKDIR}/git"

do_configure() {
    sed "s/-lpthread/-pthread/g" -i ${S}/Client/Build/ARM/makefile
}

do_compile() {
    cd ${S}/Client/Build/ARM
    oe_runmake CC="${CC}" LINKER="${CC}"
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

INSANE_SKIP_${PN} += "ldflags"
