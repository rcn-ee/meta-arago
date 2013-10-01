# Arago Qt5 test image
# gives you an image with Qt5 for basic testing purposes.

require arago-image.inc
inherit remove-net-rules

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-base-tisdk \
    matrix-gui-browser \
    qtwebkit-examples-examples \
    qtbase-plugins \
    "

export IMAGE_BASENAME = "arago-qt5-test-image"
