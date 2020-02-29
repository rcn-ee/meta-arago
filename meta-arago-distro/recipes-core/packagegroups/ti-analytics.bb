SUMMARY = "TI World packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARMNN_PACKAGES = ""
#ARMNN_PACKAGES = "${@bb.utils.contains('MACHINE_FEATURES', 'dsp', 'armnn', '', d)}"

ANALYTICS = "\
    ${ARMNN_PACKAGES} \
    tensorflow-lite-demo \
"
ANALYTICS_keystone = ""
ANALYTICS_j7-evm = ""
ANALYTICS_omapl138 = ""

RDEPENDS_${PN} = "\
    ${ANALYTICS} \
"
