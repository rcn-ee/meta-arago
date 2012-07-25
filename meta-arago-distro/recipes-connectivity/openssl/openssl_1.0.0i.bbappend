FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR = "${INC_PR}.3"

SRC_URI += " \
            file://find.pl \
            "

do_configure_prepend() {
  cp ${WORKDIR}/find.pl ${S}/util/find.pl
}
