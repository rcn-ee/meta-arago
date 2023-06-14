# Produces wic image for jailhouse

require recipes-core/images/tisdk-default-image.bb

COMPATIBLE_MACHINE = "am62xx"

IMAGE_INSTALL:append:am62xx = " jailhouse"

export IMAGE_BASENAME = "tisdk-jailhouse-image"

WIC_CREATE_EXTRA_ARGS:append = " --no-fstab-update"
