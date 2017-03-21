# Arago TI SDK filesystem image

require arago-base-tisdk-image.bb

SPLASH = ""

# Disable in master due to php breakage
#    packagegroup-arago-tisdk-matrix
IMAGE_INSTALL += "\
    packagegroup-arago-tisdk-addons \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl','',d)} \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-base-tisdk-server-extra \
    packagegroup-arago-tisdk-connectivity \
"

export IMAGE_BASENAME = "tisdk-server-rootfs-image"
