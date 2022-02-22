# look for files in this layer first
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-rtcwake-Allow-poweroff-with-rtcwake-command.patch "

PR:append = ".arago21"
