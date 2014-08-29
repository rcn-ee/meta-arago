DESCRIPTION = "Qt5 demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/qt5_apps"

do_install_prepend(){
   install -d ${D}${bindir}
   install -m 0755 ${S}/read_system_env.sh ${D}${bindir}/
}


# Make sure qt5 submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-qt5"

FILES_${PN} += "${MATRIX_BASE_DIR}/* \
                ${bindir}/read_system_env.sh"
