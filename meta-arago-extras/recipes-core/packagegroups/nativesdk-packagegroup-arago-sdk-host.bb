DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r14"
LICENSE = "MIT"

inherit packagegroup nativesdk

#               nativesdk-clocl
#               nativesdk-clacc
EXTRA_TOOLS = "nativesdk-ti-cgt6x \
               nativesdk-ti-cgt-pru \
               nativesdk-mtd-utils-ubifs \
"

RDEPENDS_${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    nativesdk-python-distutils \
    nativesdk-git \
    ${EXTRA_TOOLS} \
    "
