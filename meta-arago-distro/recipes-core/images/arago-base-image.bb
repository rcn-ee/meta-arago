# Arago base image
# gives you a small image with package manager

require arago-image.inc

IMAGE_INSTALL += "packagegroup-arago-base"

export IMAGE_BASENAME = "arago-base-image"
