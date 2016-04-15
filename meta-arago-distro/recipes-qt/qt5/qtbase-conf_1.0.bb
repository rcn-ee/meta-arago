SUMMARY = "qtbase configuration files"
HOMEPAGE = "http://www.qt.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://qt_env.sh"

# Add custom Arago qtbase Environment script file
do_install () {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/qt_env.sh ${D}${sysconfdir}/profile.d/
}

FILES_${PN} += "${sysconfdir}/profile.d/*"
