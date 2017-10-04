FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR_append = ".arago0"

#    file://0001-qtwebengine-fix-the-system-crash-due-to-mismatched-G.patch

SRC_URI += " \
    file://0002-qtwebengine-set-default-logging-level-back-to-LOG_FA.patch \
    file://0003-qtwebengine-HACK-disable-SECCOMP-BPF-Sandbox-at-star.patch \
"
