require recipes-core/images/tisdk-server-rootfs-image.bb

IMAGE_INSTALL += "\
    packagegroup-arago-test-addons \
    packagegroup-arago-tisdk-addons-extra \
    ${@bb.utils.contains('MACHINE_FEATURES','opencl','packagegroup-arago-tisdk-opencl-extra','',d)} \
    packagegroup-arago-tisdk-multimedia \
"

export IMAGE_BASENAME = "tisdk-server-extra-rootfs-image"

IMAGE_FSTYPES = "tar.gz"
