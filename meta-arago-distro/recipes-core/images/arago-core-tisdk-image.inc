# This include is for the common setting used to build TISDK images.  These images
# include both host and target side content. 
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

IMAGE_FSTYPES = "tar.gz"

inherit tisdk-image

COMPATIBLE_MACHINE = "omap3|omapl138|ti33x|ti43x|omap-a15|keystone"

# List of packages to remove from the host package.  This is usually due to
# licensing issues and unneeded dependencies.
HOST_CLEANUP_PACKAGES = ""
TOOLCHAIN_CLEANUP_PACKAGES = "libgnutls-dev libgnutls-extra26 libgnutls-openssl27 libtasn1-dev"

# Set DTB filters for each machine.  Use "unknown" by default to avoid
# picking up DTB files for devices with not DTB support.
DTB_FILTER = "unknown"
DTB_FILTER_ti33x = "am335x"
DTB_FILTER_omap5-evm = "omap5"
DTB_FILTER_dra7xx-evm = "dra7"
DTB_FILTER_am57xx-evm = "am57xx"
DTB_FILTER_ti43x = "am43"
DTB_FILTER_keystone = "k2hk"

# List of target side images to build for the SDK
TARGET_IMAGES = "arago-base-tisdk-image tisdk-rootfs-image"

# Some devices do not support display and use a server image instead
TARGET_IMAGES_keystone = "arago-base-tisdk-image tisdk-server-rootfs-image"

TISDK_TOOLCHAIN = "meta-toolchain-arago-tisdk"

TISDK_TOOLCHAIN_keystone = "meta-toolchain-arago"

IMAGE_INSTALL_QT = "\
    packagegroup-arago-tisdk-qte-sdk-host \
"

IMAGE_INSTALL_QT_keystone = ""

IMAGE_INSTALL = "\
    packagegroup-arago-tisdk-addons-sdk-host \
    packagegroup-arago-tisdk-connectivity-sdk-host \
    packagegroup-arago-tisdk-crypto-sdk-host \
    packagegroup-arago-tisdk-graphics-sdk-host \
    packagegroup-arago-tisdk-matrix-sdk-host \
    packagegroup-arago-tisdk-multimedia-sdk-host \
    packagegroup-arago-tisdk-amsdk-sdk-host \
    ${IMAGE_INSTALL_QT} \
"
