# This change has been accepted upstream and will be available in the next
# stable 1.7 release of the Yocto Project after Daisy (version 1.6).
# The updated version of the patch in the yavta directory can also be
# removed at that point.

SRCREV = "7e9f28bedc1ed3205fb5164f686aea96f27a0de2"

PR_append = "-arago0"

CFLAGS += "-I${S}/include"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
