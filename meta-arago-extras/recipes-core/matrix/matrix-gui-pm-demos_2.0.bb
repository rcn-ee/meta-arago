DESCRIPTION = "Power management demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

inherit allarch

S = "${WORKDIR}/git/power_apps"


do_install_prepend(){
   install -d ${D}${MATRIX_BASE_DIR}/html-apps/

   cp -rf ${S}/set_governor/power-set-governor ${D}${MATRIX_BASE_DIR}/html-apps/

}

do_install_append(){
    rm ${D}${MATRIX_APP_DIR}/set_governor/set-governor.php
}


# Make sure power submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-power matrix-gui-generic-pm"

# Break out the individual files into separate packages.  That way only the
# PM features supported for each device can be installed.  Prepend the list
# so that we can get the files in ${bindir} first.
PACKAGES =+ "${PN}-count ${PN}-dump-reg ${PN}-snapshot1 ${PN}-snapshot2 ${PN}-suspend ${PN}-governor"

# Split the matrix files by PM app
FILES_${PN}-count += "${MATRIX_APP_DIR}/pm_count/*"
FILES_${PN}-dump-reg += "${MATRIX_APP_DIR}/pm_dump_reg/*"
FILES_${PN}-snapshot1 += "${MATRIX_APP_DIR}/pm_snapshot_1/*"
FILES_${PN}-snapshot2 += "${MATRIX_APP_DIR}/pm_snapshot_2/*"
FILES_${PN}-suspend += "${MATRIX_APP_DIR}/pm_suspend/*"
FILES_${PN}-governor += "${MATRIX_APP_DIR}/set_governor/* \
                         ${MATRIX_BASE_DIR}/html-apps/power-set-governor/*"

# Split the ${bindir} files by PM app
FILES_${PN}-count += "${bindir}/pm_count.sh"
FILES_${PN}-dump-reg += "${bindir}/pm_dump_reg.sh"
FILES_${PN}-snapshot1 += "${bindir}/pm_snapshot_1.sh"
FILES_${PN}-snapshot2 += "${bindir}/pm_snapshot_2.sh"
FILES_${PN}-suspend += "${bindir}/pm_suspend.sh"
FILES_${PN}-governor += "${bindir}/setgovernor.sh"
