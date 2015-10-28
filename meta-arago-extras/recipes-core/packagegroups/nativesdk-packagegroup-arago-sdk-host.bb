DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r10"
LICENSE = "MIT"

inherit packagegroup nativesdk

EXTRA_TOOLS = "nativesdk-ti-cgt6x nativesdk-clocl"

RDEPENDS_${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    nativesdk-python-distutils \
    nativesdk-git \
    ${EXTRA_TOOLS} \
    "
