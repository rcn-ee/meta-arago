SUMMARY = "TI World packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARMNN_PACKAGES = ""
#ARMNN_PACKAGES = "${@bb.utils.contains('MACHINE_FEATURES', 'dsp', 'armnn', '', d)}"

TENSORFLOW_DEMO = ""
#TENSORFLOW_DEMO = " \
#    ${@oe.utils.all_distro_features(d, 'opencv', 'tensorflow-lite-demo', '')} \
#"
#TENSORFLOW_DEMO_dra7xx = " \
#    ${@['','tensorflow-lite-demo'][oe.utils.all_distro_features(d, 'opencl opencv', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
#"

ANALYTICS = ""
#ANALYTICS = " \
#    ${ARMNN_PACKAGES} \
#    ${TENSORFLOW_DEMO} \
#    ${@['','qt-opencv-opencl-opengl-multithreaded'][oe.utils.all_distro_features(d, 'opencv opencl opengl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'gpu dsp', True, False, d)]} \
#    ${@['','barcode-roi'][oe.utils.all_distro_features(d, 'opencv', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
#"
ANALYTICS_keystone = ""
ANALYTICS_j7 = ""
ANALYTICS_omapl138 = ""

RDEPENDS_${PN} = "\
    ${ANALYTICS} \
"
