# Arago base image
# gives you a small image with package manager

require arago-image.inc

# The size of the uncompressed ramdisk is 8MB
ROOTFS_SIZE = "10240"

IMAGE_INSTALL += "task-arago-base"

export IMAGE_BASENAME = "arago-base-image"
