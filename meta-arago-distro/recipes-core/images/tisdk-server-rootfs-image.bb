# Arago TI SDK filesystem image

require arago-base-tisdk-image.bb

SPLASH = ""

IMAGE_INSTALL += "\
    packagegroup-arago-test \
    packagegroup-arago-tisdk-addons \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-matrix \
    packagegroup-arago-base-tisdk-server-extra \
    gdb \
"

export IMAGE_BASENAME = "tisdk-server-rootfs-image"
