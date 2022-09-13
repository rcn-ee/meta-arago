SUMMARY = "Arago TI SDK base image with test tools"

DESCRIPTION = "Arago SDK base image suitable for initramfs containing\
 comprehensive test tools."

require arago-image.inc

IMAGE_FSTYPES += "cpio.xz"
IMAGE_FSTYPES:append:dra7xx = " ubifs ubi"

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-base-tisdk \
    ${VIRTUAL-RUNTIME_initramfs} \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', 'ti-test', '', d)} \
"

export IMAGE_BASENAME = "tisdk-base-image"
