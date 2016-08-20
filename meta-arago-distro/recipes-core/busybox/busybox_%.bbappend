# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://0001-rtcwake-Allow-poweroff-with-rtcwake-command.patch "

PR_append = ".arago21"
