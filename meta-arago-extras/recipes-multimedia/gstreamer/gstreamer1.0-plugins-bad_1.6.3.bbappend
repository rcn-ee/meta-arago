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
    file://0001-kmssink-remove-DCE-dependencies.patch \
    file://0002-kmssink-add-YUYV-support.patch \
    file://0001-gstwaylandsink-add-input-format-I420-support.patch \
"

SRC_URI_append_ti43x = " \
    file://0001-kmssink-remove-DCE-dependencies.patch \
    file://0002-kmssink-add-YUYV-support.patch \
    file://0001-gstwaylandsink-add-input-format-I420-support.patch \
"

SRC_URI_append_ti33x = " \
    file://0001-gstwaylandsink-Add-mouse-drag-and-drop-support.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/glsdk/gstreamer1-0-plugins-bad.git;protocol=git;branch=${BRANCH} \
          "

S = "${WORKDIR}/git"

SRCREV_omap-a15 = "eb41f1c8fde05f87587c83d157835e3b2d19a298"
SRCREV_ti43x = "eb41f1c8fde05f87587c83d157835e3b2d19a298"
SRCREV = "d0160ca810be30bf2b2e7681f5047933402efb52"

PR = "r25"
