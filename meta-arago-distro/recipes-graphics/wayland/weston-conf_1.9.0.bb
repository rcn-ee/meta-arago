SUMMARY = "Weston configuration files"
HOMEPAGE = "http://wayland.freedesktop.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://wayland_env.sh \
           file://weston.ini \
"

# Add custom Arago Wayland Environment script file
do_install () {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/wayland_env.sh ${D}${sysconfdir}/profile.d/
}

FILES_${PN} += "${sysconfdir}/profile.d/* ${sysconfdir}/weston.ini"
