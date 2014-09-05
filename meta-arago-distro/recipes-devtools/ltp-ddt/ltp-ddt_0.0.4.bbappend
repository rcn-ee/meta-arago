PR_append = "-arago5+gitr${SRCPV}"

PARALLEL_MAKE = ""

RDEPENDS_${PN} += "linaro-pm-qa-utils"

# Auto rev so we pick up the latest changes
SRCREV = "${AUTOREV}"

SRC_URI_remove = "file://0001-KERNEL_INC-in-modern-kernel-should-point-at-toplevel.patch"

EXTRA_OEMAKE += "KERNEL_PATH="${STAGING_KERNEL_DIR}""

do_compile_prepend () {
    do_make_scripts
}
