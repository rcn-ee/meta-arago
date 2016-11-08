FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR_append = ".arago0"

SRC_URI += " \
    file://0001-WebEngine-qquickwebengineview_p.h-add-include-QtGui-.patch \
"
