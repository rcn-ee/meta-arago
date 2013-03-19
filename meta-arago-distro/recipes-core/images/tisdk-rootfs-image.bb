# Arago TI SDK filesystem image
COMPATIBLE_MACHINE = "omap3|omapl138|ti33x|omap-a15"

require arago-base-tisdk-image.bb

IMAGE_INSTALL += "\
    packagegroup-arago-test \
    ${@base_contains('MACHINE_FEATURES','sgx','packagegroup-arago-tisdk-graphics','',d)} \
    packagegroup-arago-tisdk-qte \
    packagegroup-arago-tisdk-addons \
    packagegroup-arago-tisdk-connectivity \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-matrix \
    packagegroup-arago-tisdk-multimedia \
    packagegroup-arago-tisdk-amsdk \
"

export IMAGE_BASENAME = "tisdk-rootfs-image"
