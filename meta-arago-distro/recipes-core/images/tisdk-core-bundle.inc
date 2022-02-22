# This include is for the common setting used to build TISDK images.  These images
# include both host and target side content. 
LICENSE = "MIT"

IMAGE_FSTYPES = "tar.xz"
IMAGE_NAME_SUFFIX = ""

inherit tisdk-bundle

COMPATIBLE_MACHINE = "omapl138|ti33x|ti43x|omap-a15|k3"

# List of packages to remove from the host package.  This is usually due to
# licensing issues and unneeded dependencies.
HOST_CLEANUP_PACKAGES = ""
TOOLCHAIN_CLEANUP_PACKAGES = "libgnutls-dev libgnutls-extra26 libgnutls-openssl27 libtasn1-dev"

# Set DTB filters for each machine.  Use "unknown" by default to avoid
# picking up DTB files for devices with no DTB support.
DTB_FILTER = "unknown"
DTB_FILTER:ti33x = "am335x"
DTB_FILTER:dra7xx-evm = "dra7"
DTB_FILTER:am57xx-evm = "am57xx"
DTB_FILTER:am57xx-hs-evm = "${DTB_FILTER:am57xx-evm}"
DTB_FILTER:ti43x = "am43"
DTB_FILTER:omapl138 = "da850"
DTB_FILTER:am65xx = "am65"
DTB_FILTER:j7 = "j721e"

# List of target side images to build for the SDK
TARGET_IMAGES = "tisdk-base-image tisdk-default-image"

TISDK_TOOLCHAIN = "${@bb.utils.contains('MACHINE_FEATURES','gpu','meta-toolchain-arago-tisdk','meta-toolchain-arago-tisdk-server',d)}"
TOOLCHAIN_SUFFIX = "${@bb.utils.contains('MACHINE_FEATURES','gpu','-tisdk','-tisdk-server',d)}"

IMAGE_INSTALL = "\
    packagegroup-arago-tisdk-addons-sdk-host \
    ${@['','packagegroup-arago-tisdk-opencl-sdk-host'][oe.utils.all_distro_features(d, 'opencl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
    packagegroup-arago-tisdk-crypto-sdk-host \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-graphics-sdk-host','',d)} \
    packagegroup-arago-tisdk-matrix-sdk-host \
    packagegroup-arago-tisdk-multimedia-sdk-host \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-hmi-sdk-host','',d)} \
    packagegroup-arago-tisdk-amsdk-sdk-host${ARAGO_KERNEL_SUFFIX} \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-qte-sdk-host','',d)} \
"
