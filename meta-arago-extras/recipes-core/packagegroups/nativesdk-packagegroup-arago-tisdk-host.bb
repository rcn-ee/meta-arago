SUMMARY = "Host packages for a standalone Arago SDK with TI tools"
PR = "r2"
LICENSE = "MIT"

inherit packagegroup nativesdk

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

TIDL_TOOLS = ""
#TIDL_TOOLS = " \
#    nativesdk-tidl-import \
#    nativesdk-tidl-viewer \
#    nativesdk-tidl-utils \
#"

EXTRA_TI_TOOLS = " \
    nativesdk-ti-cgt6x \
    nativesdk-ti-cgt-pru \
    nativesdk-clocl \
    ${@oe.utils.all_distro_features(d, "opencl openmp", "nativesdk-clacc")} \
    nativesdk-open62541-examples \
    nativesdk-open62541-tests \
    nativesdk-gcc-arm-baremetal \
    ${@oe.utils.all_distro_features(d, "opencl opencv", "${TIDL_TOOLS}")} \
"

RDEPENDS:${PN} = "\
    nativesdk-packagegroup-sdk-host \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'nativesdk-wayland-dev', '', d)} \
    nativesdk-python3-distutils \
    nativesdk-python3-numpy \
    nativesdk-git \
    nativesdk-mtd-utils-ubifs \
    ${EXTRA_TI_TOOLS} \
"

RDEPENDS:${PN}:remove = "\
    nativesdk-meson \
"
