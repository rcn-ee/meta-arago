SUMMARY = "Qt Touch-Friendly WebBroswer"
HOMEPAGE = "http://blog.qt.io/blog/2016/07/18/qt-webbrowser-1-0/"
SECTION = "multimedia"
LICENSE = "GPL-3.0-only & GFDL-1.3"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPLv3;md5=a40e2bb02b1ac431f461afd03ff9d1d6 \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
"

DEPENDS += "qtbase qtdeclarative qtwebengine"
PACKAGES += "${PN}-examples"

PR = "r0"

BRANCH = "dev"
SRC_URI = "git://code.qt.io/qt-apps/qtwebbrowser.git;protocol=git;branch=${BRANCH}"
SRCREV = "a09ec269e8b296d39d78b45ae251edb3d7bada41"

S = "${WORKDIR}/git"

inherit qt5

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${datadir}/examples/webengine/webbrowser/src
    install -m 0755 src/qtwebbrowser ${D}${bindir}/qtwebbrowser
    cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${datadir}/examples/webengine/webbrowser/.
}

FILES:${PN} +=  "${bindir}/qtwebbrowser"
FILES:${PN}-examples +=  "${datadir}/examples/webengine/webbrowser/*"

RDEPENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland-qmlplugins', '', d)} \
    qtvirtualkeyboard-qmlplugins \
    qtdeclarative-qmlplugins \
    qtquickcontrols-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtmultimedia-qmlplugins \
    qtwebengine-qmlplugins \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    liberation-fonts \
    ca-certificates \
"
