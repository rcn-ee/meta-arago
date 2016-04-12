DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r15"
LICENSE = "MIT"

inherit packagegroup nativesdk

EXTRA_TOOLS = "nativesdk-ti-cgt6x \
               nativesdk-ti-cgt-pru \
               nativesdk-clocl \
               nativesdk-clacc \
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
