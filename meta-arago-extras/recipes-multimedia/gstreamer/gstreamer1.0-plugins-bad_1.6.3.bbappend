FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "faad"

# gstreamer is now also included on Keystone, be mindful of any Graphics dependencies
PACKAGECONFIG_append_omap-a15 = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"
PACKAGECONFIG_append_ti43x = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"
PACKAGECONFIG_append_ti33x = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"

DEPENDS_append_omap-a15 = " \
    libdce \
    libdrm \
"

DEPENDS_append_ti43x = " \
    libdrm \
"

DEPENDS_append_ti33x = " \
    libdrm \
"

SRC_URI_append_ti43x = " \
"

SRC_URI_append_ti33x = " \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/glsdk/gstreamer1-0-plugins-bad.git;protocol=git;branch=${BRANCH} \
          "

S = "${WORKDIR}/git"

SRCREV = "f0694b5fcec997036ef7df4d382b28e833c8ebfd"
SRCREV_ti43x = "d0160ca810be30bf2b2e7681f5047933402efb52"
SRCREV_ti33x = "d0160ca810be30bf2b2e7681f5047933402efb52"

PR = "r20"
