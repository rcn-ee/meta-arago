SUMMARY = "TI KALDI speech recognition toolkit"
HOMEPAGE = "http://kaldi-asr.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=35439d742a3df991e4f4f0e68e2d634c"

PR = "r0"
COMPATIBLE_MACHINE = "dra7xx"

require recipes-ti/includes/arago-paths.inc

SRC_URI = "git://git.ti.com/processor-sdk/kaldi.git;protocol=git;branch=${BRANCH}"
BRANCH = "kaldi_1-0-0"
SRCREV = "a472be2e2f8598a3e360bc7ca87ff4f73afa2d9e"

DEPENDS = " \
	linalg \
	openfst \
"

S = "${WORKDIR}/git"

export LINALG_DIR  = "${LINALG_INSTALL_DIR}"
export OPENFST_DIR = "${STAGING_DIR_TARGET}${prefix}"
export TARGET_ROOTDIR="${STAGING_DIR_TARGET}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
KALDI_CONF = "--static --use-cuda=no --mathlib=CLAPACK --clapack-root=${LINALG_INSTALL_DIR}/packages/ti/linalg --fst-root=${STAGING_DIR_TARGET}${prefix} --fst-version=1.6.2 --ti-cross-compile --ti-device=AM57"

EXTRA_OEMAKE = "-C src"

do_configure() {
	cd src
	chmod +x configure
	./configure ${KALDI_CONF}
}

do_compile() {
	oe_runmake online2bin featbin
}

do_install() {
	chmod +x export_kaldi.sh
	./export_kaldi.sh --nnet2-online . ${D}${datadir}/ti/examples/kaldi
}

# to create a package for KALDI
FILES_${PN} += "${datadir}/ti/examples/kaldi"
