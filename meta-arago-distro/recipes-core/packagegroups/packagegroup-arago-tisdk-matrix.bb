DESCRIPTION = "Task to include Matrix v2"
LICENSE = "MIT"
PR = "r43"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MATRIX_ESSENTIALS = "        \
    matrix-gui               \
    matrix-lighttpd-config   \
"

MATRIX_GUI = "               \
    refresh-screen           \
    matrix-gui-browser       \
"

MATRIX_GUI_keystone = ""

MATRIX_COMMON_APPS = "              \
    matrix-gui-armbenchmarks-demos  \
    matrix-gui-crypto-demos         \
    matrix-gui-oprofile-demos       \
    matrix-gui-settings-demos       \
    matrix-gui-usb-demos            \
    matrix-gui-submenus-ethernet    \
"

MATRIX_QT_APPS = "                  \
    ${@base_conditional('QT_PROVIDER', 'qt5', 'matrix-gui-qt5-demos', 'matrix-gui-qt4-demos', d)} \
    ${@base_conditional('ARAGO_QT_PROVIDER','qt4-embedded-gles','matrix-gui-apps-quick-playground','', d)} \
"
#    matrix-gui-thermostat-demo      

MATRIX_SGX_DEMOS = "                \
    matrix-3d-demo-chameleon        \
    matrix-3d-demo-film             \
    matrix-3d-demo-lantern          \
    matrix-3d-demo-skull            \
"
MATRIX_QT_APPS_keystone = ""

MATRIX_APPS = ""

MATRIX_APPS_append_omap3 = "        \
    ${@base_contains('MACHINE_FEATURES','sgx','${MATRIX_SGX_DEMOS}','',d)} \
    matrix-multimedia-demo-aac \
    matrix-multimedia-demo-h264dec      \
    matrix-multimedia-demo-mpeg4aacdec   \
    matrix-multimedia-demo-mpeg4dec     \
    ${@base_contains('DISTRO_FEATURES', 'wayland', '', 'ts-calibrate-init', d)} \
"

MATRIX_APPS_append_ti33x = "        \
    matrix-gui-ethernet-demos       \
    ${@base_contains('MACHINE_FEATURES','sgx','${MATRIX_SGX_DEMOS}','',d)} \
    matrix-multimedia-demo-aac \
    matrix-multimedia-demo-audiocapture \
    matrix-multimedia-demo-h264dec      \
    matrix-multimedia-demo-mpeg4aacdec   \
    matrix-multimedia-demo-mpeg4dec     \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-suspend     \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
                                    \
    ${@base_contains('DISTRO_FEATURES', 'wayland', '', 'ts-calibrate-init', d)} \
"

MATRIX_APPS_append_ti43x = "        \
    ${@base_contains('MACHINE_FEATURES','sgx','${MATRIX_SGX_DEMOS}','',d)} \
                                    \
    matrix-multimedia-demo-aac      \
    matrix-multimedia-demo-h264dec  \
    matrix-multimedia-demo-mpeg4aacdec \
    matrix-multimedia-demo-mpeg4dec \
                                    \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-suspend     \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
    matrix-gui-apps-dual-camera     \
    matrix-gui-apps-image-gallery   \
    ${@base_contains('DISTRO_FEATURES', 'wayland', '', 'ts-calibrate-init', d)} \
"

MATRIX_APPS_append_omap-a15 = "     \
    matrix-multimedia-demo-aac      \
    ${@base_contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-ivahdh264dec','matrix-multimedia-demo-h264dec',d)} \
    ${@base_contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-ivahdh264enc','',d)} \
    ${@base_contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-vip-vpe-ivahdmpeg4encdec','',d)} \
    ${@base_contains('MACHINE_FEATURES','mmip','','matrix-multimedia-demo-mpeg4aacdec',d)} \
    ${@base_contains('MACHINE_FEATURES','mmip','','matrix-multimedia-demo-mpeg4dec',d)} \
    matrix-gui-generic-pm           \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
    matrix-multimedia-demo-h265dec \
"

MATRIX_APPS_append_beagleboard = "  \
    matrix-gui-display-control      \
"

MATRIX_APPS_append_am3517-evm = "   \
    matrix-gui-v4l2-demos           \
"

MATRIX_APPS_append_am37x-evm = "    \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-count       \
    matrix-gui-pm-demos-dump-reg    \
    matrix-gui-pm-demos-snapshot1   \
    matrix-gui-pm-demos-snapshot2   \
    matrix-gui-pm-demos-suspend     \
                                    \
    matrix-gui-display-control      \
    matrix-gui-camera-loopback      \
    matrix-gui-v4l2-demos           \
    matrix-gui-display-control      \
    matrix-gui-clocks               \
                                    \
                                    \
    matrix-multimedia-demo-audiocapture \
"

MATRIX_APPS_append_am180x-evm = "   \
    matrix-gui-pru-demos            \
"

MATRIX_APPS_append_keystone = " \
    matrix-gui-utility-demos	\
    matrix-gui-mc-demos	\
"

RDEPENDS_${PN} = "        \
    ${MATRIX_ESSENTIALS}  \
    ${MATRIX_GUI}         \
    ${MATRIX_COMMON_APPS} \
    ${MATRIX_QT_APPS} \
    ${MATRIX_APPS}        \
"
