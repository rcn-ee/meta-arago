# Arago System Test image
# gives you test applications
LICENSE = "MIT"

require arago-image.inc

IMAGE_FSTYPES = "tar.xz"

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
