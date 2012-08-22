DESCRIPTION = "Task to include Matrix v2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

MATRIX_ESSENTIALS = "        \
    matrix-gui               \
    refresh-screen           \
    matrix-lighttpd-config   \
    matrix-gui-browser       \
"

MATRIX_COMMON_APPS = "              \
    matrix-gui-armbenchmarks-demos  \
    matrix-gui-crypto-demos         \
    matrix-gui-oprofile-demos       \
    matrix-gui-qt4-demos            \
    matrix-gui-settings-demos       \
    matrix-gui-usb-demos            \
    matrix-gui-submenus-ethernet    \
"

MATRIX_APPS = ""

MATRIX_APPS_append_omap3 = "        \
    matrix-gui-3d-demos             \
    matrix-gui-multimedia-demos     \
"

MATRIX_APPS_append_ti33x = "        \
    matrix-gui-3d-demos             \
    matrix-gui-multimedia-demos     \
                                    \
    matrix-gui-clocks               \
    matrix-gui-clocks-275mhz        \
    matrix-gui-clocks-500mhz        \
    matrix-gui-clocks-600mhz        \
    matrix-gui-clocks-720mhz        \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-suspend     \
    matrix-gui-wifi-demos           \
"

MATRIX_APPS_append_beagleboard = "  \
    matrix-gui-display-control      \
"

MATRIX_APPS_append_am3517-evm = "   \
    matrix-gui-v4l2-demos           \
"

MATRIX_APPS_append_am37x-evm = "    \
    matrix-gui-clocks               \
    matrix-gui-clocks-300mhz        \
    matrix-gui-clocks-600mhz        \
    matrix-gui-clocks-800mhz        \
    matrix-gui-clocks-1ghz          \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-count       \
    matrix-gui-pm-demos-dump-reg    \
    matrix-gui-pm-demos-snapshot1   \
    matrix-gui-pm-demos-snapshot2   \
    matrix-gui-pm-demos-suspend     \
                                    \
    matrix-gui-wifi-demos           \
    matrix-gui-display-control      \
    matrix-gui-camera-loopback      \
    matrix-gui-v4l2-demos           \
    matrix-gui-display-control      \
"

RDEPENDS_append_am180x-evm = "  \
    matrix-gui-wifi-demos       \
"

RDEPENDS_${PN} = "        \
    ${MATRIX_ESSENTIALS}  \
    ${MATRIX_COMMON_APPS} \
    ${MATRIX_APPS}        \
"
