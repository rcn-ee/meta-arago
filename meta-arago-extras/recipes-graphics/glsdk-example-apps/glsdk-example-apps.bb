SUMMARY = "GLSDK example applications"
HOMEPAGE = "http://git.ti.com/glsdk"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=10a9abb9c5bb19edd83a8cf66eef7148"

DEPENDS = "gstreamer1.0 libdrm libdce ti-ipc wayland weston"

COMPATIBLE_MACHINE = "dra7xx"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

SRC_URI = "git://git.ti.com/git/glsdk/example-applications.git;protocol=https;branch=master \
"

SRCREV="52466430609c402a9f1c0667ccf727d096336d0d"

PR = "r53"

CFLAGS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', '-DEGL_NO_X11',d)}"

do_install:append () {
    install -d ${D}${sysconfdir}/glsdkstatcoll
    install -m 0644 ${S}/bandwidth-tool/config.ini ${D}${sysconfdir}/glsdkstatcoll/.
    install -m 0644 ${S}/bandwidth-tool/initiators.cfg ${D}${sysconfdir}/glsdkstatcoll/.

    install -d ${D}${sysconfdir}/visualization_scripts
    install -m 0644 ${S}/cpuload-plugins/scripts/*.sh  ${D}${sysconfdir}/visualization_scripts/.
    install -m 0644 ${S}/cpuload-plugins/scripts/*.cfg ${D}${sysconfdir}/visualization_scripts/.
}

FILES:${PN} += "${sysconfdir}/glsdkstatcoll/* ${sysconfdir}/visualization_scripts/*"
