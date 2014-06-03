# Arago TI SDK filesystem image

require arago-base-tisdk-image.bb

IMAGE_INSTALL += "\
    packagegroup-arago-test \
    ${@base_contains('MACHINE_FEATURES','sgx','packagegroup-arago-tisdk-graphics','',d)} \
    ${@base_contains('QT_PROVIDER','qt5','packagegroup-arago-tisdk-qt5','packagegroup-arago-tisdk-qte',d)} \
    packagegroup-arago-tisdk-addons \
    packagegroup-arago-tisdk-connectivity \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-matrix \
    packagegroup-arago-tisdk-multimedia \
    packagegroup-arago-tisdk-amsdk \
"

export IMAGE_BASENAME = "tisdk-rootfs-image"
