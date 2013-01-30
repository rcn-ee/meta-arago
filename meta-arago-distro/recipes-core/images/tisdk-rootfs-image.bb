# Arago TI SDK filesystem image
COMPATIBLE_MACHINE = "omap3|omapl138|ti33x"

require arago-base-tisdk-image.bb

IMAGE_INSTALL += "\
    packagegroup-arago-test \
    packagegroup-arago-tisdk-graphics \
    packagegroup-arago-tisdk-qte \
    packagegroup-arago-tisdk-addons \
    packagegroup-arago-tisdk-connectivity \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-matrix \
    packagegroup-arago-tisdk-multimedia \
    packagegroup-arago-tisdk-amsdk \
"

export IMAGE_BASENAME = "tisdk-rootfs-image"
