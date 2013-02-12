LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_FSTYPES = "tar.gz"

inherit tisdk-image

COMPATIBLE_MACHINE = "omap3|omapl138|ti33x"

# List of packages to remove from the host package.  This is usually due to
# licensing issues and unneeded dependencies.
HOST_CLEANUP_PACKAGES = ""
TOOLCHAIN_CLEANUP_PACKAGES = "libgnutls-dev libgnutls-extra26 libgnutls-openssl27 libtasn1-dev"

SECONDARY_BOOTLOADER_NAME_omapl138 = ""

# List of target side images to build for the SDK
TARGET_IMAGES = "arago-base-tisdk-image tisdk-rootfs-image"

TISDK_TOOLCHAIN = "meta-toolchain-arago-tisdk"

IMAGE_INSTALL = "\
    packagegroup-arago-tisdk-addons-sdk-host \
    packagegroup-arago-tisdk-connectivity-sdk-host \
    packagegroup-arago-tisdk-crypto-sdk-host \
    packagegroup-arago-tisdk-matrix-sdk-host \
    packagegroup-arago-tisdk-multimedia-sdk-host \
    packagegroup-arago-tisdk-qte-sdk-host \
    packagegroup-arago-tisdk-amsdk-sdk-host \
"

export IMAGE_BASENAME = "arago-amsdk-image"
