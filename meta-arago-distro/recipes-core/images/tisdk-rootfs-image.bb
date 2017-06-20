# Arago TI SDK full filesystem image

require arago-image.inc

# Disabled in master due to php breakage
#    packagegroup-arago-tisdk-matrix
#    packagegroup-arago-tisdk-matrix-extra
IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-base-tisdk \
    packagegroup-arago-test \
    packagegroup-arago-test-addons \
    ${@bb.utils.contains('MACHINE_FEATURES','sgx','packagegroup-arago-tisdk-graphics','',d)} \
    packagegroup-arago-tisdk-qte \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl-extra','',d)} \
    packagegroup-arago-tisdk-connectivity \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-multimedia \
    packagegroup-arago-tisdk-amsdk \
    packagegroup-arago-tisdk-addons \
    packagegroup-arago-tisdk-addons-extra \
    "

export IMAGE_BASENAME = "tisdk-rootfs-image"
