# Arago TI SDK base image with test tools
# Suitable for initramfs

require arago-image.inc

IMAGE_FSTYPES += "cpio.xz"
IMAGE_FSTYPES_append_dra7xx = " ubifs ubi"

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-base-tisdk \
    ${VIRTUAL-RUNTIME_initramfs} \
    "

export IMAGE_BASENAME = "tisdk-base-image"
