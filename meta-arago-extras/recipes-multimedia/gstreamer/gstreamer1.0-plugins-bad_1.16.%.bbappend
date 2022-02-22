FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG:append = " faad kms"

GSTDRM_WAYLANDSINK_PATCHES = " \
    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
    file://0002-parsers-bug-fixes-on-parsers.patch \
    file://0003-kmssink-Add-omapdrm-and-tidss-in-the-list-of-drivers.patch \
    file://0004-waylandsink-Add-drm-support-in-waylandsink.patch \
    file://0005-waylandsink-Add-input-device-support.patch \
    file://0001-wayland-drm-kms-add-support-for-meson-build-system.patch \
    file://0001-gstdrm-Remove-wayland-as-required-dependency.patch \
"

SRC_URI:append:ti43x = " \
    ${GSTDRM_WAYLANDSINK_PATCHES} \
"

SRC_URI:append:ti33x = " \
    file://0001-waylandsink-Add-mouse-drag-and-drop-support.patch \
"

SRC_URI:append:omap-a15 = " \
    ${GSTDRM_WAYLANDSINK_PATCHES} \
"

SRC_URI:append:am65xx = " \
    ${GSTDRM_WAYLANDSINK_PATCHES} \
"

SRC_URI:append:j7-evm = " \
    ${GSTDRM_WAYLANDSINK_PATCHES} \
"

SRC_URI:append:j7-hs-evm = " \
    ${GSTDRM_WAYLANDSINK_PATCHES} \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR:append = ".arago4"
