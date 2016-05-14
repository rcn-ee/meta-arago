FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Add-option-to-run-a-test-indefinitely.patch"

PR_append = ".arago0"
