FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR_append = ".tisdk0"

SRC_URI += " \
    file://0001-touchinteraction.qml-Add-exit-button.patch \
"

