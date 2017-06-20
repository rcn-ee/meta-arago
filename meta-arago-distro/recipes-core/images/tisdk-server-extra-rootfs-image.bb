require recipes-core/images/tisdk-server-rootfs-image.bb

IMAGE_INSTALL += "\
    packagegroup-arago-test-addons \
    packagegroup-arago-tisdk-addons-extra \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl-extra','',d)} \
    packagegroup-arago-tisdk-multimedia \
    packagegroup-arago-tisdk-matrix-extra \
"

export IMAGE_BASENAME = "tisdk-server-extra-rootfs-image"

IMAGE_FSTYPES = "tar.xz"
