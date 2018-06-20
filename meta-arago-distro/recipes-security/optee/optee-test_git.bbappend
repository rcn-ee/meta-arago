FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-test.git;branch=${BRANCH}"

SRC_URI += "file://0001-host-xtest-Makefile-fix-COMPILE_NS_USER-not-being-se.patch"

PV = "3.1.0+git${SRCPV}"

BRANCH = "ti_optee_test"
SRCREV = "b284eedf4fa20c21403ececfe0a47af55fbaa5d8"
