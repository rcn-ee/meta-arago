ARAGO_SYSVINIT = "1"

require arago-image.inc

IMAGE_FSTYPES += "cpio"

# Install a small set of utils which can be used for diagnostics
ARAGO_TINY_IMAGE_EXTRA_INSTALL ?= " \
	parted \
	util-linux \
	e2fsprogs \
	dosfstools \
	devmem2 \
	arago-feed-config \
"

IMAGE_INSTALL = " \
	packagegroup-arago-sysvinit-boot \
	${ARAGO_TINY_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "arago-tiny-image"
