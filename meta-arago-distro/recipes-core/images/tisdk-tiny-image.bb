ARAGO_TINY_IMAGE_EXTRA_INSTALL ?= ""

require arago-tiny-image.inc

IMAGE_FEATURES_remove = "package-management"

IMAGE_FSTYPES += "cpio cpio.xz"

IMAGE_INSTALL += " \
	${ARAGO_TINY_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "tisdk-tiny-image"
