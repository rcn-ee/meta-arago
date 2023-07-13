# Set alternative link for applications like Qt that really need
# ${libdir}/libvulkan.so to point to an actual ICD loader instead of using
# libvulkan.so.1

inherit update-alternatives

ALTERNATIVE_PRIORITY = "10"
ALTERNATIVE:${PN} = "vulkan-loader"
ALTERNATIVE_LINK_NAME[vulkan-loader] = "${libdir}/libvulkan.so"
ALTERNATIVE_TARGET[vulkan-loader] = "libvulkan.so.1"
