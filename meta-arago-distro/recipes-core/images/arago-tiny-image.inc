ARAGO_SYSVINIT = "1"

require arago-image.inc

IMAGE_FEATURES:remove = "splash"

IMAGE_INSTALL = " \
	packagegroup-arago-sysvinit-boot \
"
