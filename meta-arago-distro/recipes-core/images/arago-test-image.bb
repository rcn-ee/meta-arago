# Arago System Test image
# gives you test applications
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

require arago-image.inc

IMAGE_FSTYPES = "tar.gz ext2.gz"

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-base-tisdk \
    packagegroup-arago-tisdk-crypto \
    packagegroup-arago-tisdk-addons \
    packagegroup-arago-test \
    packagegroup-arago-test-addons \
    "

export IMAGE_BASENAME = "arago-test-image"
