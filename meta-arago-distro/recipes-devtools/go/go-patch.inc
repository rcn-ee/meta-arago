
FILESEXTRAPATHS:prepend := "${THISDIR}/go:"

SRC_URI:remove = "file://0001-cmd-go-make-content-based-hash-generation-less-pedan.patch"
SRC_URI:append = "file://0001-panic-fix.patch"

