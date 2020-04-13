FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG_append = " faad kms"

SRC_URI_append_ti43x = " \
    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
    file://0002-parsers-bug-fixes-on-parsers.patch \
    file://0003-kmssink-Add-omapdrm-and-tidss-in-the-list-of-drivers.patch \
    file://0004-waylandsink-Add-drm-support-in-waylandsink.patch \
    file://0005-waylandsink-Add-input-device-support.patch \
    file://0001-wayland-drm-kms-add-support-for-meson-build-system.patch \
"

SRC_URI_append_ti33x = " \
    file://0001-waylandsink-Add-mouse-drag-and-drop-support.patch \
"

SRC_URI_append_omap-a15 = " \
    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
    file://0002-parsers-bug-fixes-on-parsers.patch \
    file://0003-kmssink-Add-omapdrm-and-tidss-in-the-list-of-drivers.patch \
    file://0004-waylandsink-Add-drm-support-in-waylandsink.patch \
    file://0005-waylandsink-Add-input-device-support.patch \
    file://0001-wayland-drm-kms-add-support-for-meson-build-system.patch \
"

SRC_URI_append_k3 = " \
    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
    file://0002-parsers-Pick-bug-fixes-on-different-parsers.patch \
    file://0003-kmssink-Add-omapdrm-and-tidss-in-the-list-of-drivers.patch \
    file://0004-waylandsink-Add-drm-support-in-waylandsink.patch \
    file://0005-waylandsink-Add-input-device-support.patch \
    file://0001-wayland-drm-kms-add-support-for-meson-build-system.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR_append = ".arago3"
