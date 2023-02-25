DESCRIPTION = "Task to include Matrix v2"
LICENSE = "MIT"
PR = "r81"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES =+ "${PN}-extra"

MATRIX_ESSENTIALS = "        \
    matrix-gui               \
    matrix-lighttpd-config   \
"

MATRIX_GUI = "               \
    refresh-screen           \
    matrix-gui-browser       \
"
MATRIX_GUI:omapl138 = ""

MATRIX_COMMON_APPS = "              \
    matrix-gui-armbenchmarks-demos  \
    matrix-gui-crypto-demos         \
    matrix-gui-oprofile-demos       \
    matrix-gui-settings-demos       \
    matrix-gui-usb-demos            \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'matrix-gui-weston-terminal-demo', '', d)} \
"

MATRIX_QT_APPS = " \
    matrix-qt5-demo-animated \
    matrix-qt5-demo-webkit-browser \
    matrix-qt5-demo-calculator \
    matrix-qt5-demo-deform \
    matrix-gui-thermostat-demo \
"

MATRIX_QT_APPS:append:omap-a15 = " \
    matrix-analytics-pdm-anomaly-detection \
    matrix-hmi-demo-evse            \
    matrix-hmi-demo-mmwavegesture   \
"

MATRIX_QT_APPS:append:am65xx = " \
    matrix-analytics-pdm-anomaly-detection \
                                    \
    matrix-hmi-demo-evse            \
    matrix-hmi-demo-mmwavegesture   \
"

MATRIX_QT_APPS:append:ti33x = " \
    matrix-analytics-pdm-anomaly-detection \
    matrix-hmi-demo-evse            \
    matrix-hmi-demo-protection-relays \
    matrix-hmi-demo-mmwavegesture   \
"

MATRIX_QT_APPS:append:ti43x = " \
    matrix-analytics-pdm-anomaly-detection \
    matrix-gui-apps-dual-camera     \
    matrix-gui-apps-image-gallery   \
                                    \
    matrix-hmi-demo-evse            \
    matrix-hmi-demo-mmwavegesture   \
"

MATRIX_TOUCH_APPS = " \
    ${@bb.utils.contains('MACHINE_FEATURES','touchscreen','matrix-gui-touch-demos','',d)} \
"

MATRIX_GPU_DEMOS = " \
    matrix-3d-demo-kmscube \
"

MATRIX_GPU_DEMOS:append:omap-a15 = " \
    matrix-3d-demo-kmscubevideo \
"

MATRIX_GPU_DEMOS:omapl138 = ""

MATRIX_OPENCL_APPS = " \
    matrix-opencl-demo-floatcompute  \
    matrix-opencl-demo-vecadd        \
"

MATRIX_OPENCL_APPS:append:dra7xx = " \
    matrix-video-analytics-opencv-opencl-opengl-demo \
    matrix-machinevision-demo-dlp3dscanner \
"

MATRIX_OPENCV_ARM_ONLY_APPS = " \
     matrix-machinevision-demo-barcoderoi \
     matrix-machinevision-demo-simplepeopletracking \
"

MATRIX_OPENCV_OPENCL_APPS = " \
    matrix-machinevision-demo-barcoderoi-f2f \
"

MATRIX_OPENCV_OPENCL_APPS:omap-a15 = " \
     matrix-machinevision-demo-barcoderoi \
     matrix-machinevision-demo-simplepeopletracking \
"

MATRIX_APPS = ""

MATRIX_APPS:append:ti33x = "        \
    matrix-multimedia-demo-aac      \
    matrix-multimedia-demo-audiocapture \
    matrix-multimedia-demo-h264dec  \
    matrix-multimedia-demo-mpeg4aacdec  \
    matrix-multimedia-demo-mpeg4dec \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-suspend     \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
                                    \
    matrix-gui-ethernet-demos       \
                                    \
    ${MATRIX_OPENCV_ARM_ONLY_APPS}  \
"

MATRIX_APPS:append:ti43x = "        \
    matrix-multimedia-demo-aac      \
    matrix-multimedia-demo-audiocapture \
    matrix-multimedia-demo-h264dec  \
    matrix-multimedia-demo-mpeg4aacdec \
    matrix-multimedia-demo-mpeg4dec \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-suspend     \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
                                    \
    ${MATRIX_OPENCV_ARM_ONLY_APPS}  \
"

MATRIX_APPS:append:omap-a15 = "     \
    matrix-multimedia-demo-aac      \
    matrix-multimedia-demo-audiocapture \
    matrix-multimedia-demo-h265dec  \
                                    \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-ivahdh264dec','matrix-multimedia-demo-h264dec',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-ivahdh264enc','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-ivahdmjpegenc','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-vip-vpe-ivahdmpeg4encdec','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','','matrix-multimedia-demo-mpeg4aacdec',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','','matrix-multimedia-demo-mpeg4dec',d)} \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
"

#    ${@['','matrix-gui-browser-demos'][bb.utils.contains('DISTRO_FEATURES','opengl',True,False,d) and bb.utils.contains('DISTRO_FEATURES','wayland',True,False,d)]} \
#                                \
#

MATRIX_APPS:append:am65xx = "           \
    matrix-multimedia-demo-aac      \
    matrix-multimedia-demo-audiocapture \
    matrix-multimedia-demo-h264dec  \
    matrix-multimedia-demo-mpeg4aacdec \
    matrix-multimedia-demo-mpeg4dec \
                                    \
    ${MATRIX_OPENCV_ARM_ONLY_APPS}  \
"

MATRIX_APPS:append:dra7xx = " \
    matrix-multimedia-demo-dsp66imgproc \
    matrix-tidl-demo-staticimg \
    matrix-tidl-demo-pnexamples \
    matrix-tidl-demo-livecam \
    matrix-tidl-demo-livecam-lg2 \
    matrix-tidl-demo-staticimg-lg2 \
    matrix-tidl-demo-staticimg-dsponly \
    matrix-tidl-demo-objdet \
    matrix-tidl-demo-objdet-livecam \
    matrix-tidl-demo-segment \
    matrix-tidl-demo-dogbreeds \
"

RDEPENDS:${PN} = "        \
    ${MATRIX_ESSENTIALS}  \
    ${MATRIX_APPS}        \
    ${MATRIX_COMMON_APPS} \
    ${@bb.utils.contains('MACHINE_FEATURES','touchscreen',"${MATRIX_TOUCH_APPS}",'',d)} \
    ${@bb.utils.contains('DISTRO_FEATURES','opengl',"${MATRIX_GUI}",'',d)} \
    ${@bb.utils.contains('DISTRO_FEATURES','opengl',"${MATRIX_QT_APPS}",'',d)} \
    ${@bb.utils.contains('DISTRO_FEATURES','opengl',"${MATRIX_GPU_DEMOS}",'',d)} \
    ${@['',"${MATRIX_OPENCL_APPS}"][oe.utils.all_distro_features(d, 'opencl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
"

RDEPENDS:${PN}-extra = " \
    ${@['',"${MATRIX_OPENCV_OPENCL_APPS}"][oe.utils.all_distro_features(d, 'opencl opencv', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
"
