FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"

SRCREV = "76bb57d539cb43d267e561024c34e031bf351e04"

SRC_URI += " \
file://0001-meson-check-for-gles3-support.patch \
"

CFLAGS += "-fcommon"

PR:append = ".arago2"
