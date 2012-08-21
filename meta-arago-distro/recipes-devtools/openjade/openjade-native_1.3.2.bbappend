FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago0"

SRC_URI += " \
            file://msggen.pl.patch \
            "
