LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_FSTYPES = "tar.bz2"

inherit tisdk-image

COMPATIBLE_MACHINE = "omap3|omapl138|ti33x"

# List of packages to remove from the host package.  This is usually due to
# licensing issues and unneeded dependencies.
HOST_CLEANUP_PACKAGES = ""
TOOLCHAIN_CLEANUP_PACKAGES = ""

# List of target side images to build for the SDK
TARGET_IMAGES = "arago-base-tisdk-image"

IMAGE_INSTALL = "task-arago-tisdk-addons-sdk-host"

export IMAGE_BASENAME = "arago-amsdk-image"

