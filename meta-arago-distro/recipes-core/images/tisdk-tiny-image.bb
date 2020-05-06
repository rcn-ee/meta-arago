ARAGO_SYSVINIT = "1"

require arago-image.inc

IMAGE_FEATURES_remove = "package-management splash"

IMAGE_FSTYPES += "cpio cpio.xz"

ARAGO_TINY_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL = " \
	packagegroup-arago-sysvinit-boot \
	${ARAGO_TINY_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "tisdk-tiny-image"
