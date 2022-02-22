DESCRIPTION = "Keystone utility app demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/utilities_apps"

do_install:prepend(){
   install -d ${D}${MATRIX_BASE_DIR}/html-apps/
   cp -rf ${S}/utility_eeprom/eeprom ${D}${MATRIX_BASE_DIR}/html-apps/
   cp -rf ${S}/utility_filesystem/filesystem ${D}${MATRIX_BASE_DIR}/html-apps/
   cp -rf ${S}/utility_info/info ${D}${MATRIX_BASE_DIR}/html-apps/
   cp -rf ${S}/utility_stats/stats ${D}${MATRIX_BASE_DIR}/html-apps/
}

do_install:append(){
    rm ${D}${MATRIX_APP_DIR}/utility_eeprom/eeprom-utility.php
    rm ${D}${MATRIX_APP_DIR}/utility_filesystem/filesystem-utility.php
    rm ${D}${MATRIX_APP_DIR}/utility_info/info-utility.php
    rm ${D}${MATRIX_APP_DIR}/utility_stats/stats-utility.php
}

# Make sure utility submenu and app images has been installed.
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-utility"

FILES:${PN} += "${MATRIX_BASE_DIR}/html-apps/ \
                ${MATRIX_BASE_DIR}/apps/ \
"
