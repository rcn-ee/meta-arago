PREFERRED_PROVIDER_virtual/kernel = "linux-ti-mainline"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-ti-mainline"
PREFERRED_PROVIDER_u-boot = "u-boot-ti-mainline"
SRCREV_ti-upstream-tools:pn-linux-ti-mainline = "${AUTOREV}"

# GPU support requires out-of-tree SGX and RGX drivers not available in mainline
MACHINE_FEATURES:remove = "gpu"
