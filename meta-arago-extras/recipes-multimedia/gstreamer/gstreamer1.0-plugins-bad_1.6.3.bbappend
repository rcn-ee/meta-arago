FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "faad"

# gstreamer is now also included on Keystone, be mindful of any Graphics dependencies
PACKAGECONFIG_append_omap-a15 = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"
PACKAGECONFIG_append_ti43x = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"
PACKAGECONFIG_append_ti33x = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"

DEPENDS_append_omap-a15 = " \
    libdrm \
"

DEPENDS_append_ti43x = " \
    libdrm \
"

DEPENDS_append_ti33x = " \
    libdrm \
"

SRC_URI_append_omap-a15 = " \
"

SRC_URI_append_ti43x = " \
"

SRC_URI_append_ti33x = " \
    file://0001-gstwaylandsink-Add-mouse-drag-and-drop-support.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/glsdk/gstreamer1-0-plugins-bad.git;protocol=git;branch=${BRANCH} \
          "

S = "${WORKDIR}/git"

SRCREV_omap-a15 = "9a1cd733fa57e1eace21524456b652087d04168e"
SRCREV_ti43x = "3a5a7f778b3c3259faab04748e7b10f0fd696aab"
SRCREV = "d0160ca810be30bf2b2e7681f5047933402efb52"

PR = "r29"
