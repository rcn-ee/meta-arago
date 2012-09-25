################################################################################
######################### TSU EXEMPTION REQUIRED ###############################
################################################################################
# Versions of openssl that are TSU Exempted:
# openssl-1.0.0a
# openssl-1.0.0d
#
# This package requires TSU exemption. Any update to the version of openssl being
# appended must be double checked to see if a new TSU exemption must be made.

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago5"

SRC_URI += "file://find.pl \
            file://0002-Modify-eng_cryptodev.c-to-make-SHA1-and-MD5-work-wit.patch \
"

do_configure_prepend() {
  cp ${WORKDIR}/find.pl ${S}/util/find.pl
}
