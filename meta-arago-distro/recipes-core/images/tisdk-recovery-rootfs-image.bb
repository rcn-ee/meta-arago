# TI SDK recovery filesystem image
COMPATIBLE_MACHINE = "keystone"

require arago-image.inc

IMAGE_INSTALL += "\
    packagegroup-arago-tisdk-recoveryfs \
"

export IMAGE_BASENAME = "tisdk-recoveryfs"
