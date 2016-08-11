# Arago console image
# gives you an image with basic media libraries

require arago-image.inc

COMPATIBLE_MACHINE = "(?!arago)"

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    "

export IMAGE_BASENAME = "arago-console-image"
