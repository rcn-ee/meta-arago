# Common file for patches or tweaks that are needed by qt4-embedded and
# qt4-embedded-gles

PR := "${PR}-arago3"

# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# Qt/E from Nokia is dual-licensed (LGPLv2.1 or GPLv3)
# For our distribution purposes we only use LGPLv2.1
LICENSE = "LGPLv2.1"

SRC_URI += "file://0001-PATCH-make-demos-maximized-for-TISDK-use.patch"
