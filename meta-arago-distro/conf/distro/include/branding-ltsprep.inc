
PREFERRED_VERSION_linux-ti-staging = "6.1%"
PREFERRED_VERSION_linux-ti-staging-rt = "6.1%"
PREFERRED_VERSION_linux-ti-staging-systest = "6.1%"
PREFERRED_VERSION_u-boot-ti-staging = "2023.04%"

# GPU support requires out-of-tree SGX and RGX drivers not available in until
# LTS prep is complete.  fall back to software rendering
MACHINE_FEATURES:remove = "gpu"
PREFERRED_PROVIDER_virtual/gpudriver = ""
