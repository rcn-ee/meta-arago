# Set extra preferences based on the product branding (AM-SDK, MC-SDK, etc)
# Examples could be different PREFERRED_PROVIDER or PREFERRED_VERSION
# As well as some other configurable aspects or variables
# Please avoid creating multiple versions of the same brand, if possible
# The policy is for the "Core" brand to be the default,
# hence this file is mostly empty and used as a template

# Lower opencl-monitor priority for now
ALTERNATIVE_PRIORITY_pn-opencl-monitor = "1"
ALTERNATIVE_PRIORITY_pn-opencl-monitor-ipu = "1"

# Raise priority for sample IPC FW images
ALTERNATIVE_PRIORITY_pn-ti-ipc-rtos = "15"

# Temporarily disable UBI images for K2 "server" rootfs due to size
IMAGE_FSTYPES_remove_pn-tisdk-server-rootfs-image = "ubi ubifs"
