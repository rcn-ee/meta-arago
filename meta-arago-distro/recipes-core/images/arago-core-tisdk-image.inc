# This include is for the common setting used to build TISDK images.  These images
# include both host and target side content. 
LICENSE = "MIT"

IMAGE_FSTYPES = "tar.xz"
IMAGE_NAME_SUFFIX = ""

inherit tisdk-image

COMPATIBLE_MACHINE = "omap3|omapl138|ti33x|ti43x|omap-a15|keystone|k3"

# List of packages to remove from the host package.  This is usually due to
# licensing issues and unneeded dependencies.
HOST_CLEANUP_PACKAGES = ""
TOOLCHAIN_CLEANUP_PACKAGES = "libgnutls-dev libgnutls-extra26 libgnutls-openssl27 libtasn1-dev"

# Set DTB filters for each machine.  Use "unknown" by default to avoid
# picking up DTB files for devices with no DTB support.
DTB_FILTER = "unknown"
DTB_FILTER_ti33x = "am335x"
DTB_FILTER_omap5-evm = "omap5"
DTB_FILTER_dra7xx-evm = "dra7"
DTB_FILTER_am57xx-evm = "am57xx"
DTB_FILTER_am57xx-hs-evm = "${DTB_FILTER_am57xx-evm}"
DTB_FILTER_ti43x = "am43"
DTB_FILTER_k2hk = "k2hk"
DTB_FILTER_k2l = "k2l"
DTB_FILTER_k2e = "k2e"
DTB_FILTER_k2g = "k2g"
DTB_FILTER_omapl138 = "da850"
DTB_FILTER_am65xx-evm = "am65"

# List of target side images to build for the SDK
TARGET_IMAGES = "arago-base-tisdk-image tisdk-rootfs-image arago-tiny-image"

# dra71 lcard requires an initramfs with modules for NFS boot
TARGET_IMAGES_append_dra7xx-evm = " netboot-initrd"

# Some devices do not support display and use a server image instead
TARGET_IMAGES_keystone = "arago-base-tisdk-image tisdk-server-rootfs-image tisdk-server-extra-rootfs-image arago-tiny-image"
TARGET_IMAGES_omapl138 = "arago-base-tisdk-image tisdk-server-rootfs-image tisdk-server-extra-rootfs-image arago-tiny-image"

TISDK_TOOLCHAIN = "meta-toolchain-arago-tisdk"
TOOLCHAIN_SUFFIX = "-tisdk"

TISDK_TOOLCHAIN_keystone = "meta-toolchain-arago-tisdk-server"
TOOLCHAIN_SUFFIX_keystone = "-tisdk-server"
TISDK_TOOLCHAIN_omapl138 = "meta-toolchain-arago-tisdk-server"
TOOLCHAIN_SUFFIX_omapl138 = "-tisdk-server"

IMAGE_INSTALL_QT = "\
    packagegroup-arago-tisdk-qte-sdk-host \
"

IMAGE_INSTALL_QT_keystone = ""
IMAGE_INSTALL_QT_omapl138 = ""

IMAGE_INSTALL = ""
# Disable all "sdk-host" packagegroups due to issues installing "srcipk" packages
#    packagegroup-arago-tisdk-addons-sdk-host \
#    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl-sdk-host','',d)} \
#    packagegroup-arago-tisdk-crypto-sdk-host \
#    ${@bb.utils.contains('MACHINE_FEATURES','sgx','packagegroup-arago-tisdk-graphics-sdk-host','',d)} \
#    packagegroup-arago-tisdk-matrix-sdk-host \
#    packagegroup-arago-tisdk-multimedia-sdk-host \
#    packagegroup-arago-tisdk-hmi-sdk-host \
#    packagegroup-arago-tisdk-amsdk-sdk-host${ARAGO_KERNEL_SUFFIX} \
#    ${IMAGE_INSTALL_QT} \
#"
