# Arago TI SDK filesystem image
COMPATIBLE_MACHINE = "omap3|omapl138|ti33x"

require arago-image.inc

IMAGE_INSTALL += "\
    task-arago-base \
    task-arago-console \
    task-arago-test \
    task-arago-base-tisdk \
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
