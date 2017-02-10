PR_append = ".arago1"

SRC_URI = "git://git.ti.com/optee/ti-optee-test.git;branch=${BRANCH}"
SRC_URI += "file://fix-build-failure-with-GCC6.patch"

BRANCH = "ti_optee_test"
SRCREV = "ba271a6e3eb2bbb6996b5de73918216f64a9e077"
