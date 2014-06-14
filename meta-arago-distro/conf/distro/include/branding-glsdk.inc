# GLSDK branding configuration

# Use the SDK supported kernel and kernel version
PREFERRED_PROVIDER_virtual/kernel = "linux-ti-glsdk"

PREFERRED_PROVIDER_virtual/bootloader_omap-a15 = "u-boot-ti-staging"
PREFERRED_PROVIDER_u-boot_omap-a15 = "u-boot-ti-staging"

# Set the PREFERRED_VERSION of libdrm to the glsdk version for the 
# glsdk branded builds
PREFERRED_VERSION_libdrm = "2.4.41"
