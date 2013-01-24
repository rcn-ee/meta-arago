# Arago TI SDK filesystem image
COMPATIBLE_MACHINE = "omap3|omapl138|ti33x"

require arago-base-tisdk-image.bb

IMAGE_INSTALL += "\
    task-arago-test \
    task-arago-tisdk-graphics \
    task-arago-tisdk-qte \
    task-arago-tisdk-addons \
    task-arago-tisdk-connectivity \
    task-arago-tisdk-crypto \
    task-arago-tisdk-matrix \
    task-arago-tisdk-multimedia \
    task-arago-tisdk-amsdk \
"

export IMAGE_BASENAME = "tisdk-rootfs-image"
