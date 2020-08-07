# This include is for the common setting used to build TISDK images.  These images
# include both host and target side content. 
LICENSE = "MIT"

IMAGE_FSTYPES = "tar.xz"
IMAGE_NAME_SUFFIX = ""

inherit tisdk-bundle

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
DTB_FILTER_am65xx = "am65"
DTB_FILTER_j7 = "j721e"

# List of target side images to build for the SDK
TARGET_IMAGES = "tisdk-base-image tisdk-default-image"

# dra71 lcard requires an initramfs with modules for NFS boot
TARGET_IMAGES_append_dra7xx-evm = " netboot-initrd"

TISDK_TOOLCHAIN = "${@bb.utils.contains('MACHINE_FEATURES','gpu','meta-toolchain-arago-tisdk','meta-toolchain-arago-tisdk-server',d)}"
TOOLCHAIN_SUFFIX = "${@bb.utils.contains('MACHINE_FEATURES','gpu','-tisdk','-tisdk-server',d)}"

IMAGE_INSTALL = "\
    packagegroup-arago-tisdk-addons-sdk-host \
    ${@['','packagegroup-arago-tisdk-opencl-sdk-host'][oe.utils.all_distro_features(d, 'opencl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
    packagegroup-arago-tisdk-crypto-sdk-host \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-graphics-sdk-host','',d)} \
    packagegroup-arago-tisdk-matrix-sdk-host \
    packagegroup-arago-tisdk-multimedia-sdk-host \
    packagegroup-arago-tisdk-hmi-sdk-host \
    packagegroup-arago-tisdk-amsdk-sdk-host${ARAGO_KERNEL_SUFFIX} \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-qte-sdk-host','',d)} \
"
