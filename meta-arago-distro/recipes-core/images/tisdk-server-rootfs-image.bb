# Arago TI SDK filesystem image

require arago-base-tisdk-image.bb

SPLASH = ""

IMAGE_INSTALL += "\
    packagegroup-arago-tisdk-addons \
    ${@bb.utils.contains('MACHINE_FEATURES','opencl','packagegroup-arago-tisdk-opencl','',d)} \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-matrix \
    packagegroup-arago-base-tisdk-server-extra \
    packagegroup-arago-tisdk-connectivity \
"

export IMAGE_BASENAME = "tisdk-server-rootfs-image"
