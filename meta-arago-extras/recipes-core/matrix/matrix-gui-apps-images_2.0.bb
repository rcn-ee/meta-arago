DESCRIPTION = "Image package for Matrix GUI v2 Applications"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/images"

do_install(){
    install -d ${D}${MATRIX_APP_DIR}
    cp -rf ${S}/ ${D}${MATRIX_APP_DIR}
}

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
