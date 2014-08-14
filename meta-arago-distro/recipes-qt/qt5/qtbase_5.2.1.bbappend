FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

GLES_EXTRA_DEPS = ""
GLES_EXTRA_DEPS_omap-a15 = "libdrm wayland"

PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"

PR_append = "-arago2"

QT_CONFIG_FLAGS += "-qpa wayland"

SRC_URI += "file://qt_env.sh"

# Add custom Arago Qt 5 Environment script file
do_install_append () {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/qt_env.sh ${D}${sysconfdir}/profile.d/
}

PACKAGES =+ "${PN}-conf"

FILES_${PN}-conf = "${sysconfdir}/profile.d/qt_env.sh"

RDEPENDS_${PN} += "${PN}-conf"
