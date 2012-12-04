# Arago TI SDK filesystem image
COMPATIBLE_MACHINE = "omap3|omapl138|ti33x|keystone"

require arago-image.inc

IMAGE_INSTALL += "\
    task-arago-base \
    task-arago-console \
    task-arago-base-tisdk \
    task-arago-tisdk-addons \
    task-arago-tisdk-crypto \
    task-arago-tisdk-matrix \
    gdb \
"

export IMAGE_BASENAME = "tisdk-rootfs"
