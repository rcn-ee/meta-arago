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
        file://0001-Enable-mouse-movement-for-videos-on-waylandsink.patch \
"

SRC_URI_append_ti33x = " \
        file://0001-Enable-mouse-movement-for-videos-on-waylandsink.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://git.ti.com/glsdk/gstreamer1-0-plugins-bad.git;protocol=git \
          "

S = "${WORKDIR}/git"

SRCREV = "3a7dce1011d2ad002f9341c8f0be2e409d73ea7b"
SRCREV_ti43x = "a536c9e8d9cfaf47759dc194449a1887e0aee15d"
SRCREV_ti33x = "a536c9e8d9cfaf47759dc194449a1887e0aee15d"

PR_append = "-arago10"
