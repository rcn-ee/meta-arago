SUMMARY = "TI FFTW"
HOMEPAGE = "http://git.ti.com/fftlib"
LICENSE = "BSD-3-Clause"

LIC_FILES_CHKSUM = "file://../docs/TI-FFTW_3.1.0_manifest.html;md5=aaa275ec704a738216ba696898941b44"

include fftlib.inc

PR = "${INC_PR}.0"

DEPENDS = "ti-fftw"

RDEPENDS_${PN} += "ti-fftw-staticdev"

S = "${WORKDIR}/git/ti/fftw/examples"

EXTRA_OEMAKE += "TARGET_ROOTDIR="${STAGING_DIR_TARGET}""

do_install() {
    install -d ${D}${datadir}/ti/examples/fftw
    cp -r ./* ${D}${datadir}/ti/examples/fftw
}

FILES_${PN} = "${datadir}/ti/examples/fftw"
INSANE_SKIP_${PN} = "ldflags"
