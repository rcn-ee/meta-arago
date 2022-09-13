SUMMARY = "Arago TI SDK Thin Linux image"

DESCRIPTION = "Minimal bootable image with container to start the next\
 complex system up."

require arago-image.inc

SPLASH = "${@bb.utils.contains('MACHINE_FEATURES','gpu','psplash','',d)}"

# Allow users to tack on additional packages as interesting.
ARAGO_THIN_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-base-tisdk \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','packagegroup-arago-tisdk-graphics','',d)} \
    docker \
    ${ARAGO_THIN_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "tisdk-thinlinux-image"

# Disable ubi/ubifs as the filesystem requires more space than is
# available on the HW.
IMAGE_FSTYPES:remove:omapl138 = "ubifs ubi"
