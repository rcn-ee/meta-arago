DESCRIPTION = "Video Analytics demo descriptions for Matrix v2"

require recipes-core/matrix/matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/videoanalytics_apps"

# Make sure video analytics submenu and app images has been installed
VIDEO_ANALYTICS_DEMO_RDEPENDS += " \
    matrix-gui-apps-images \
    matrix-gui-submenus-videoanalytics \
"

PACKAGES = "matrix-video-analytics-opencv-opencl-opengl-demo \
"

#    ${@['','qt-opencv-opencl-opengl-multithreaded'][oe.utils.all_distro_features(d, 'opencv opencl opengl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'gpu dsp', True, False, d)]}
RDEPENDS:matrix-video-analytics-opencv-opencl-opengl-demo = " \
    ${VIDEO_ANALYTICS_DEMO_RDEPENDS} \
"

# Split the matrix files by demos
FILES:matrix-video-analytics-opencv-opencl-opengl-demo = " \
    ${MATRIX_APP_DIR}/videoanalytics_opencv_opencl_opengl_demo/* \
"
