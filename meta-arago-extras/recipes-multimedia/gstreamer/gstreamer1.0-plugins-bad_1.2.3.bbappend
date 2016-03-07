FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "faad"

PACKAGECONFIG_append_omap-a15 = " ${@base_contains('DISTRO_FEATURES','wayland','wayland','',d)}"
PACKAGECONFIG_append_ti43x = " ${@base_contains('DISTRO_FEATURES','wayland','wayland','',d)}"
PACKAGECONFIG_append_ti33x = " ${@base_contains('DISTRO_FEATURES','wayland','wayland','',d)}"

SRC_URI_append_ti43x = " \
        file://0001-Enable-mouse-movement-for-videos-on-waylandsink.patch \
"

SRC_URI_append_ti33x = " \
        file://0001-Enable-mouse-movement-for-videos-on-waylandsink.patch \
"

DEPENDS_append_omap-a15 = " \
    libdce \
    libdrm \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://git.ti.com/glsdk/gstreamer1-0-plugins-bad.git;protocol=git \
          "

S = "${WORKDIR}/git"

SRCREV = "9396248f2daf0b28b83ab0f01c4d17a8af46b1ca"
SRCREV_ti43x = "a536c9e8d9cfaf47759dc194449a1887e0aee15d"
SRCREV_ti33x = "a536c9e8d9cfaf47759dc194449a1887e0aee15d"

PR_append = "-arago7"

