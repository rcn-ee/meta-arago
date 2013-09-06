DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
PR = "r4"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

QT_SGX_SUPPORT = "\
    qt4-embedded-plugin-gfxdriver-gfxpvregl \
    libqt-embeddedopengl4 \
    libqt-embeddedpvrqwswsegl4 \
"

RDEPENDS_${PN} = "\
    qt4-embedded \
    qt4-embedded-plugin-mousedriver-tslib \
    qt4-embedded-plugin-gfxdriver-gfxtransformed \
    qt4-embedded-plugin-phonon-backend-gstreamer \
    qt4-embedded-plugin-imageformat-gif \
    qt4-embedded-plugin-imageformat-jpeg \
    qt4-embedded-qml-plugins \
    libqt-embeddedmultimedia4 \
    libqt-embeddeddeclarative4 \
    libqt-embeddedxmlpatterns4 \
    ${@base_conditional('ARAGO_QT_PROVIDER', 'qt4-embedded-gles', '${QT_SGX_SUPPORT}', '', d)} \
"
