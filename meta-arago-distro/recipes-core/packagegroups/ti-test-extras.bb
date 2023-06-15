SUMMARY = "TI Testing packagegroup for big tests"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARAGO_TEST_EXTRAS = "\
    piglit \
    ${@bb.utils.contains("DISTRO_FEATURES", "opengl", "opengl-es-cts", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "vulkan", "vulkan-cts", "", d)} \
"

RDEPENDS:${PN} = "\
    ${ARAGO_TEST_EXTRAS} \
"
