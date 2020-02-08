FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "python3-pycryptodomex-native"

PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-test.git;branch=${BRANCH}"
BRANCH = "ti-optee-test"
SRCREV = "7c68d7b098b19363ada3c48b133484b018254fb1"
