# Common pieces for Arago images

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

# 4KB per 1 inode should be enough
EXTRA_IMAGECMD_ext2.gz += "-i 4096"

IMAGE_INSTALL += " \
	${ROOTFS_PKGMANAGE} \
"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "sysvinit"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "tinylogin shadow"

export IMAGE_BASENAME = "arago-image"

IMAGE_LINGUAS = ""

inherit image
