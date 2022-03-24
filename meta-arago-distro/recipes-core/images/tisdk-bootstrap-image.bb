SUMMARY = "Arago TI SDK bootstrap image usable for board bringup"

DESCRIPTION = "This image is a complete package containing a rootfs\
 and an initrd with platform test utilities that can be used for new\
 platform bringup activities. Typically one would use the bootstrap\
 initrd till the storage media access is debugged, following which one\
 would switch over to using the storage media of choice with the same\
 content.\
"

require arago-tiny-image.inc

ARAGO_BOOTSTRAP_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-arago-bootstrap \
	kernel-base \
	bootstrap-initrd \
	${ARAGO_BOOTSTRAP_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "tisdk-bootstrap-image"
