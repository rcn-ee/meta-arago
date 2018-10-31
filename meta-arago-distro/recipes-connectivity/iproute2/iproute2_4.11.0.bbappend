PR_append = ".arago4"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
           file://0001-add-support-for-prp-similar-to-hsr.patch \
           file://0001-hsr-prp-add-support-for-vlan-tagged-sv-frames.patch \
           file://0001-hsr-prp-remove-the-debug-print-from-the-code.patch \
           file://0001-hsr-prp-disable-display-for-vlan-params-in-ip-d-link.patch \
           file://0002-prp-invalid-maxattr.patch \
           file://0001-hsr-prp-replace-cfi-use-in-code-with-dei.patch \
          "
