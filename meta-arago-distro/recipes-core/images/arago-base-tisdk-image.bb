# Arago TI SDK base image
# gives you an image with Qt/E and other common packages shared by all TI SDKs.

require arago-image.inc
inherit remove-net-rules

COMPATIBLE_MACHINE = "omap3|ti816x|dm365|omapl138|ti814x|omap4|ti33x|omap-a15"

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-base-tisdk \
    "

export IMAGE_BASENAME = "arago-base-tisdk-image"
