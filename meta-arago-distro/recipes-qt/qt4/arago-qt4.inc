# Common file for patches or tweaks that are needed by qt4-embedded and
# qt4-embedded-gles

PR := "${PR}-arago8"

# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

python __anonymous () {
    d.setVar("RRECOMMENDS_libqt-embeddedcore4", "")
}

# Qt/E from Nokia is dual-licensed (LGPLv2.1 or GPLv3)
# For our distribution purposes we only use LGPLv2.1
LICENSE = "LGPLv2.1"

SRC_URI += "file://0001-PATCH-make-demos-maximized-for-TISDK-use.patch \
            file://0002-qwslock-messages.patch \
            file://qte.sh \
"

# Rotate the display only for am37x_evm
do_install_prepend_am37x-evm () {
    echo "export QWS_DISPLAY="transformed:Rot90" >> ${WORKDIR}/qte.sh
}
