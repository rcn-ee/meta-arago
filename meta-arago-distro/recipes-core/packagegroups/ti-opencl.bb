# This is just an alias between debian and OE names

LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES += "${PN}-runtime"

RDEPENDS_${PN} = "opencl"
RDEPENDS_${PN}-runtime = "opencl-runtime"
