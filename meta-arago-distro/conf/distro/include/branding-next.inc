PREFERRED_PROVIDER_virtual/kernel = "linux-ti-next"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-ti-mainline"
PREFERRED_PROVIDER_u-boot = "u-boot-ti-mainline"
SRCREV:pn-linux-ti-next = "${AUTOREV}"
SRCREV:pn-u-boot-ti-mainline = "${AUTOREV}"

# GPU support requires out-of-tree SGX and RGX drivers not available in next
# fall back to software rendering
MACHINE_FEATURES:remove = "gpu"
PREFERRED_PROVIDER_virtual/gpudriver = ""
