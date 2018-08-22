FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG[wayland] = "--enable-wayland-backend,--disable-wayland-backend,wayland wayland-protocols libxkbcommon virtual/egl wayland-native"
GTKGLIBC_RRECOMMENDS = "${GTKBASE_RRECOMMENDS}"

PR_append = ".arago0"

SRC_URI += "\
    file://0001-gdkglcontext-wayland.c-cleanup-the-parameters-of-egl.patch \
"
