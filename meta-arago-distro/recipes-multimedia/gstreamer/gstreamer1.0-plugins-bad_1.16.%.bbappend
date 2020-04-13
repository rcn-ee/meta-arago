# Remove all GFX PACKAGECONFIGs for platforms w/o GPU
PACKAGECONFIG_remove = "${@bb.utils.contains('MACHINE_FEATURES','gpu','','x11 wayland gl egl gles2 qt5',d)}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR_append = ".0"
