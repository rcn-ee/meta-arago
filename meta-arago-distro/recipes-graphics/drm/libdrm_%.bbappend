FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Add-option-to-run-a-test-indefinitely.patch"

PR_append = ".arago1"

inherit update-alternatives

ALTERNATIVE_PRIORITY = "10"
ALTERNATIVE_${PN} = "kmstest"
ALTERNATIVE_LINK_NAME[kmstest] = "${bindir}/kmstest"
