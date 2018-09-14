FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago1"

SRC_URI = "git://git.ti.com/optee/ti-optee-test.git;branch=${BRANCH}"

SRC_URI += "file://0001-host-xtest-Makefile-fix-COMPILE_NS_USER-not-being-se.patch"

PV = "3.2.0+git${SRCPV}"

BRANCH = "ti_optee_test"
SRCREV = "36c8eef15437f2280e657be7d296564452e3c427"
