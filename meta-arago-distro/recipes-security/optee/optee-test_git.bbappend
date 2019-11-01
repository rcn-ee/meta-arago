FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit python3native

DEPENDS += "python3-pycrypto-native"

PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-test.git;branch=${BRANCH}"

PV = "3.7.0+git${SRCPV}"

BRANCH = "ti-optee-test"
SRCREV = "7c68d7b098b19363ada3c48b133484b018254fb1"
