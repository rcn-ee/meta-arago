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
    file://0001-gstwaylandsink-Add-mouse-drag-and-drop-support.patch \
"

SRC_URI_append_ti33x = " \
    file://0001-gstwaylandsink-Add-mouse-drag-and-drop-support.patch \
"

SRC_URI_append_omap-a15 = " \
    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
    file://0002-parsers-Pick-previos-bug-fixes-on-different-parsers.patch \
    file://0003-gstkmssink-Add-support-for-KMS-based-sink.patch \
    file://0004-gstwaylandsink-Add-DRM-support-on-waylandsink.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r3"
