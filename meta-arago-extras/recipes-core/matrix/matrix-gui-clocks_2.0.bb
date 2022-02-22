DESCRIPTION = "Clock setting descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.4"

inherit allarch

S = "${WORKDIR}/git/clocks_apps"

do_install:prepend(){
   install -d ${D}${MATRIX_BASE_DIR}/html-apps/

   cp -rf ${S}/set_frequency/power-set-frequency ${D}${MATRIX_BASE_DIR}/html-apps/

}

do_install:append(){
    rm ${D}${MATRIX_APP_DIR}/set_frequency/set-frequency.php
}
# Make sure power submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-power matrix-gui-generic-pm"

FILES:${PN} += "${MATRIX_BASE_DIR}/html-apps/ \
                ${MATRIX_BASE_DIR}/apps/ \
"
