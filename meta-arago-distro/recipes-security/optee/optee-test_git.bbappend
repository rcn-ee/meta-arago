FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-test.git;branch=${BRANCH}"

SRC_URI += "file://0001-host-xtest-Makefile-fix-COMPILE_NS_USER-not-being-se.patch"

PV = "3.5.0+git${SRCPV}"

BRANCH = "ti-optee-test"
SRCREV = "e4f6f76b4cb5763112f4722981f84a26f4ac7e55"
