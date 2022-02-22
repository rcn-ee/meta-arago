DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
PR = "r16"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = "\
    qtbase-plugins \
    qtdeclarative-qmlplugins \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland-plugins', '', d)} \
    qt3d-qmlplugins \
    qtquickcontrols-qmlplugins \
    qtquickcontrols2-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtvirtualkeyboard-plugins \
    qtvirtualkeyboard-qmlplugins \
    qtwebkit-qmlplugins \
    liberation-fonts \
    qtconnectivity \
    qtconnectivity-qmlplugins \
"
