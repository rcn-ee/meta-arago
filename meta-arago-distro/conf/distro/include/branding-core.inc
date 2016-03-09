# Set extra preferences based on the product branding (AM-SDK, MC-SDK, etc)
# Examples could be different PREFERRED_PROVIDER or PREFERRED_VERSION
# As well as some other configurable aspects or variables
# Please avoid creating multiple versions of the same brand, if possible
# The policy is for the "Core" brand to be the default,
# hence this file is mostly empty and used as a template

# Auto rev important packages to pick up latest
SRCREV_pn-linux-ti-staging = "${AUTOREV}"
SRCREV_pn-linux-ti-staging-rt = "${AUTOREV}"
SRCREV_pn-linux-ti-staging-systest = "${AUTOREV}"
SRCREV_pn-u-boot-ti-staging = "${AUTOREV}"
SRCREV_pn-ltp-ddt = "${AUTOREV}"

# Lower opencl-monitor priority for now
ALTERNATIVE_PRIORITY_pn-opencl-monitor = "1"

# Raise priority for sample IPC FW images
ALTERNATIVE_PRIORITY_pn-ti-ipc-rtos-fw = "15"
