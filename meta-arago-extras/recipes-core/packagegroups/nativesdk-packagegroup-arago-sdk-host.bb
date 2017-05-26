SUMMARY = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r16"
LICENSE = "MIT"

inherit packagegroup nativesdk

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

EXTRA_TI_TOOLS = " \
    nativesdk-ti-cgt6x \
    nativesdk-ti-cgt-pru \
    nativesdk-clocl \
    nativesdk-clacc \
"

RDEPENDS_${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    nativesdk-autoconf \
    nativesdk-automake \
    nativesdk-shadow \
    nativesdk-makedevs \
    nativesdk-python-distutils \
    nativesdk-git \
    nativesdk-cmake \
    nativesdk-mtd-utils-ubifs \
    ${EXTRA_TI_TOOLS} \
"
