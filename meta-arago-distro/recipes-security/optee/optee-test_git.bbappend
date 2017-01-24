PR_append = ".arago1"

SRC_URI = "git://git.ti.com/optee/ti-optee-test.git;branch=${BRANCH}"
SRC_URI += "file://fix-build-failure-with-GCC6.patch"

BRANCH = "ti_optee_test"
SRCREV = "6203b8769beff4eccf7104a6474991114691bf90"
