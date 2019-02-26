SUMMARY = "Host packages for a standalone Arago SDK with TI tools"
PR = "r0"
LICENSE = "MIT"

inherit packagegroup nativesdk

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

EXTRA_TI_TOOLS = " \
    nativesdk-ti-cgt6x \
    nativesdk-ti-cgt-pru \
    nativesdk-clocl \
    nativesdk-clacc \
    nativesdk-open62541-examples \
    nativesdk-open62541-tests \
    nativesdk-tidl-import \
    nativesdk-gcc-arm-none-eabi \
"

RDEPENDS_${PN} = "\
    nativesdk-packagegroup-arago-sdk-host \
    ${EXTRA_TI_TOOLS} \
"
