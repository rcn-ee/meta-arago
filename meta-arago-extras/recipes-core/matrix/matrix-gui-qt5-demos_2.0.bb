DESCRIPTION = "Qt5 demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

SRC_URI_append_k3 = " \
           file://0001-qt5_broswer-use-webkit-browser-instead-of-webengine-.patch;pnum=2 \
"

S = "${WORKDIR}/git/qt5_apps"

# Make sure qt5 submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-qt5"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
