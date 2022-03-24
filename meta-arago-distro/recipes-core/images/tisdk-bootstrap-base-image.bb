SUMMARY = "Arago TI SDK bootstrap base image for initramfs"

DESCRIPTION = "Image meant for basic system verification of linux kernel.\
 Intended as basic test system, this image does not package the kernel\
 in the standard /boot folder in rootfs. Instead, it provides a base\
 rootfs with enough basic board bringup utilities allowing kernel to be\
 deployed elsewhere (tftp/separate boot partition/jtag log etc..) and\
 maybe used for basic platform bringup (bootstrap) activities.\
"

require arago-tiny-image.inc

IMAGE_FSTYPES += "cpio cpio.xz"

ARAGO_BOOTSTRAP_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-arago-bootstrap \
	${ARAGO_BOOTSTRAP_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "tisdk-bootstrap-base-image"
