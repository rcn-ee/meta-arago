# Set extra preferences based on the product branding (AM-SDK, MC-SDK, etc)
# Examples could be different PREFERRED_PROVIDER or PREFERRED_VERSION
# As well as some other configurable aspects or variables
# Please avoid creating multiple versions of the same brand, if possible
# The policy is for the "Core" brand to be the default,
# hence this file is mostly empty and used as a template

# Lower opencl-monitor priority for now
ALTERNATIVE_PRIORITY_pn-opencl-monitor = "1"

# Raise priority for sample IPC FW images
ALTERNATIVE_PRIORITY_pn-ti-ipc-rtos = "15"

# Temporarily disable "mmip" machine feature for all SOCs while building
# latest code base, until gstreamer support is available for 1.8.3
MACHINE_FEATURES := "${@d.getVar('MACHINE_FEATURES', True).replace('mmip', '')}"
