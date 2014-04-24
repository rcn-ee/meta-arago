# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago0"

SRC_URI += "file://0001-wpa_gui-make-the-networkconfig-dialog-scrollable.patch \
            file://0002-wpa-gui-e-fix-display-issue-on-small-screen.patch \
            file://0003-wpa-gui-trigger-udhcpc-on-connection-to-new-access-p.patch \
            file://connection_script.sh"

do_install_append () {
       install -d ${D}${datadir}/wpa_gui
       install -m 0755 ${WORKDIR}/connection_script.sh ${D}${datadir}/wpa_gui
}

FILES_${PN} += "${datadir}/wpa_gui/connection_script.sh"
