FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR_append = ".arago1"

SRC_URI += " \
    file://0003-qtwebengine-HACK-disable-SECCOMP-BPF-Sandbox-at-star.patch \
"

DEPENDS += "bison-native"
