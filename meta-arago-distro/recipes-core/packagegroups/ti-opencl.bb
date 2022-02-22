# This is just an alias between debian and OE names

LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES += "${PN}-runtime"

RDEPENDS:${PN} = "opencl"
RDEPENDS:${PN}-runtime = "opencl-runtime"
