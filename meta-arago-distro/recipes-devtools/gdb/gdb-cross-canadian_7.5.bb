require ${COREBASE}/meta/recipes-devtools/gdb/gdb-common.inc
require gdb-cross-canadian.inc

PR = "${INC_PR}.0"
PR_append = "-arago0"

GDBPROPREFIX = "--program-prefix='${TARGET_PREFIX}'"

S = "${WORKDIR}/${BPN}-${PV}"
