PR_append = "-arago9+gitr${SRCPV}"

RDEPENDS_${PN} += "linaro-pm-qa-utils"

SRC_URI_remove = "file://0001-KERNEL_INC-in-modern-kernel-should-point-at-toplevel.patch"

EXTRA_OEMAKE += "KERNEL_PATH="${STAGING_KERNEL_DIR}""

KERNEL_MODULES_META_PACKAGE = "${PN}"

# do_make_scripts should be a separate task for the lock to work
addtask make_scripts before do_compile
do_make_scripts[lockfiles] = "${TMPDIR}/kernel-scripts.lock"
do_make_scripts[deptask] = "do_populate_sysroot"
