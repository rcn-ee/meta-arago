FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
PR:append = ".tisdk1"

CXXFLAGS:append:omap-a15 = " -DQ_OS_BLACKBERRY"


SRC_URI += " \
    file://0001-touchinteraction.qml-Add-exit-button.patch \
"

