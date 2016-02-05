# Arago TI SDK filesystem image

require arago-base-tisdk-image.bb

SPLASH = ""

IMAGE_INSTALL += "\
    packagegroup-arago-test \
    packagegroup-arago-tisdk-addons \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-matrix \
    packagegroup-arago-base-tisdk-server-extra \
    packagegroup-arago-test \
    packagegroup-arago-test-addons \
"

BAD_RECOMMENDATIONS += " \
    ti-llvm3.6-dev \
    opencl-monitor-dev \
    libulm-dev \
    gdbserver-c6x-dev \
"

export IMAGE_BASENAME = "tisdk-server-rootfs-image"
