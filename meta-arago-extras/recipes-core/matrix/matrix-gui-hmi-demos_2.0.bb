SUMMARY = "HMI demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require recipes-core/matrix/matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/hmi_apps"

# Make sure machinevision submenu and app images has been installed
HMI_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-hmi"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

PACKAGES = "matrix-hmi-demo-evse \
	    matrix-hmi-demo-protection-relays\
"

RDEPENDS_matrix-hmi-demo-evse = " \
    bash \
    ${HMI_RDEPENDS} \
    evse-hmi \
"

RDEPENDS_matrix-hmi-demo-protection-relays = " \
    bash \
    ${HMI_RDEPENDS} \
    protection-relays-hmi \
"

FILES_matrix-hmi-demo-evse    = "${MATRIX_APP_DIR}/hmi_evse/*"
FILES_matrix-hmi-demo-evse  += "${bindir}/runHmiEvse.sh"

FILES_matrix-hmi-demo-protection-relays   = "${MATRIX_APP_DIR}/hmi_protection_relays/*"
FILES_matrix-hmi-demo-protection-relays  += "${bindir}/runHmiProtectionRelays.sh"
