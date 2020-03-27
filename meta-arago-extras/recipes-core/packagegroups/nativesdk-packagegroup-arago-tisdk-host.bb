SUMMARY = "Host packages for a standalone Arago SDK with TI tools"
PR = "r0"
LICENSE = "MIT"

inherit packagegroup nativesdk

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

#    nativesdk-open62541-examples
#    nativesdk-open62541-tests
EXTRA_TI_TOOLS = " \
    nativesdk-ti-cgt6x \
    nativesdk-ti-cgt-pru \
    nativesdk-clocl \
    nativesdk-clacc \
    nativesdk-tidl-import \
    nativesdk-tidl-viewer \
    nativesdk-tidl-utils \
    nativesdk-gcc-arm-none-eabi \
"

RDEPENDS_${PN} = "\
    nativesdk-packagegroup-sdk-host \
    nativesdk-python-distutils \
    nativesdk-git \
    nativesdk-mtd-utils-ubifs \
    ${EXTRA_TI_TOOLS} \
"
