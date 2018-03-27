FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR_append = ".tisdk1"

CXXFLAGS_append_omap-a15 = " -DQ_OS_BLACKBERRY"


SRC_URI += " \
    file://0001-touchinteraction.qml-Add-exit-button.patch \
"

