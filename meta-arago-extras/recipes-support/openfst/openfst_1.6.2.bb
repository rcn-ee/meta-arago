SUMMARY = "OpenFst: library for operating on finite-state transducers"
DESCRIPTION = "OpenFst: a library for constructing, combining, optimizing, and searching weighted finite-state transducers (FSTs)"
LICENSE = "Apache-2.0"
HOMEPAGE = "http://www.openfst.org/twiki/bin/view/FST/WebHome"
PR ="r0"

LIC_FILES_CHKSUM = "file://COPYING;md5=17bdccf7f927b4b2aeac950537db3369"
SRC_URI = "http://openslr.org/resources/2/openfst-${PV}.tar.gz"

S = "${WORKDIR}/openfst-${PV}"

SRC_URI[md5sum] = "e5b2b8c41a8320a03f3a8bbea63bb0ca"
SRC_URI[sha256sum] = "3f72e35097fdf1c1c41e15165c16696c223295b40b7b145b5466306db7972578"

inherit autotools pythonnative

# From the OpenFST documentation:
#
#Optional features:
#
#  --enable-bin             Enable fst::script and executables (def: yes)
#  --enable-compact-fsts    Enable CompactFst extensions (def: no)
#  --enable-compress        Enable compression extension (def: no)
#  --enable-const-fsts      Enable ConstFst extensions (def: no)
#  --enable-far             Enable FAR extensions (def: no)
#  --enable-grm             Enable all dependencies of OpenGrm (def: no)
#  --enable-linear-fsts     Enable LinearTagger/ClassifierFst extensions (def: no)
#  --enable-lookahead-fsts  Enable LookAheadFst extensions (def: no)
#  --enable-mpdt            Enable MPDT extensions (def: no)
#  --enable-ngram-fsts      Enable NGramFst extensions (def: no)
#  --enable-pdt             Enable PDT extensions (def: no)
#  --enable-python          Enable Python extension (def: no)
#  --enable-special         Enable special-matcher extensions (def: no)

PACKAGECONFIG ??= "bin static-only-libs far ngram-fsts"

PACKAGECONFIG[bin] = "--enable-bin,--disable-bin,,"
PACKAGECONFIG[static-only-libs] = "--enable-static --disable-shared,--enable-static --enable-shared,,"
PACKAGECONFIG[compact-fsts] = "--enable-compact-fsts,--disable-compact-fsts,,"
PACKAGECONFIG[compress] = "--enable-compress,--disable-compress,zlib,"
PACKAGECONFIG[const-fsts] = "--enable-const-fsts,--disable-const-fsts,,"
PACKAGECONFIG[far] = "--enable-far,--disable-far,,"
PACKAGECONFIG[grm] = "--enable-grm,--disable-grm,,"
PACKAGECONFIG[linear-fsts] = "--enable-linear-fsts,--disable-linear-fsts,,"
PACKAGECONFIG[lookahead-fsts] = "--enable-lookahead-fsts,--disable-lookahead-fsts,,"
PACKAGECONFIG[mpdt] = "--enable-mpdt,--disable-mpdt,,"
PACKAGECONFIG[ngram-fsts] = "--enable-ngram-fsts,--disable-ngram-fsts,,"
PACKAGECONFIG[pdt] = "--enable-pdt,--disable-pdt,,"
PACKAGECONFIG[python] = "--enable-python,--disable-python,,${PYTHON_PN}"
PACKAGECONFIG[special] = "--enable-special,--disable-special,,"

FILES_${PN} += "${libdir}/fst/* ${PYTHON_SITEPACKAGES_DIR}/*"
FILES_${PN}-dev += "${libdir}/fst/*${SOLIBSDEV} ${libdir}/fst/*.la ${PYTHON_SITEPACKAGES_DIR}/*.la"
FILES_${PN}-staticdev += "${libdir}/fst/*.a ${PYTHON_SITEPACKAGES_DIR}/*.a"

ALLOW_EMPTY_${PN} = "${@bb.utils.contains("PACKAGECONFIG", "bin", "0", "1", d)}"
