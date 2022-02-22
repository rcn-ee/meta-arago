DESCRIPTION = "Power management demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.4"

inherit allarch

S = "${WORKDIR}/git/power_apps"

# Make sure power submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-power matrix-gui-generic-pm"
ALLOW_EMPTY:${PN} = "1"

# Break out the individual files into separate packages.  That way only the
# PM features supported for each device can be installed.  Prepend the list
# so that we can get the files in ${bindir} first.
PACKAGES =+ "${PN}-count ${PN}-dump-reg ${PN}-snapshot1 ${PN}-snapshot2 ${PN}-suspend ${PN}-governor"

# Split the matrix files by PM app
FILES:${PN}-count += "${MATRIX_APP_DIR}/pm_count/*"
FILES:${PN}-dump-reg += "${MATRIX_APP_DIR}/pm_dump_reg/*"
FILES:${PN}-snapshot1 += "${MATRIX_APP_DIR}/pm_snapshot_1/*"
FILES:${PN}-snapshot2 += "${MATRIX_APP_DIR}/pm_snapshot_2/*"
FILES:${PN}-suspend += "${MATRIX_APP_DIR}/pm_suspend/*"
FILES:${PN}-governor += "${MATRIX_APP_DIR}/pm_userspace_governor/* \
                         ${MATRIX_APP_DIR}/pm_ondemand_governor/*"

# Split the ${bindir} files by PM app
FILES:${PN}-count += "${bindir}/pm_count.sh"
FILES:${PN}-dump-reg += "${bindir}/pm_dump_reg.sh"
FILES:${PN}-snapshot1 += "${bindir}/pm_snapshot_1.sh"
FILES:${PN}-snapshot2 += "${bindir}/pm_snapshot_2.sh"
FILES:${PN}-suspend += "${bindir}/pm_suspend.sh"
FILES:${PN}-governor += "${bindir}/setgovernor.sh"
