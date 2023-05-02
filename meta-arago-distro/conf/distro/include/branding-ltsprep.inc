
PREFERRED_VERSION_linux-ti-staging = "6.1%"
PREFERRED_VERSION_linux-ti-staging-rt = "6.1%"
PREFERRED_VERSION_linux-ti-staging-systest = "6.1%"
PREFERRED_VERSION_u-boot-ti-staging = "2023.04%"

# Remove mmip - DRM allocator, KMS sink, Wayland sink need porting to GST 1.18
MACHINE_FEATURES:remove = "mmip"

# GC320 support requires out-of-tree drivers not available in until LTS prep is
# complete. Disable for now.
MACHINE_FEATURES:remove = "gc320"
