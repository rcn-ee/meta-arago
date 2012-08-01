# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago0"

SRC_URI += "file://0001-opkg_message-send-Collected-errors-messages-to-stder.patch"
