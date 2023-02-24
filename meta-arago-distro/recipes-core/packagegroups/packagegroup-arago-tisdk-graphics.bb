SUMMARY = "Task to install graphics packages"
LICENSE = "MIT"
PR = "r26"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GFX_WAYLAND = "\
    weston-init \
    weston-examples \
"

GFX_UTILS = ""
GFX_UTILS:append:omap-a15  = "\
    glsdk-util-scripts \
"

RDEPENDS:${PN} = "\
    libegl \
    glmark2 \
    ${@bb.utils.contains('MACHINE_FEATURES', 'gc320', 'ti-gc320-tests', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', "${GFX_WAYLAND}", '', d)} \
    ${GFX_UTILS} \
"
