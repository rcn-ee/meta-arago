FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

GLES_EXTRA_DEPS = ""
GLES_EXTRA_DEPS_omap-a15 = "libdrm wayland"

PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"

PR_append = "-arago7"

QT_CONFIG_FLAGS += "-qpa ${@base_contains('DISTRO_FEATURES', 'wayland', 'wayland', 'eglfs', d)}"

QT_EGLFS_PATCHES = "\
    file://0001-calculator-Add-exit-button-for-non-window-environmen.patch \
    file://0002-animatedtiles-Add-exit-button-for-non-window-environ.patch \
    file://quit.png \
"

QT_ENV = "qt_env.sh"
QT_ENV_ti33x = "${@base_contains('DISTRO_FEATURES', 'wayland', 'qt_env.sh', 'qt_env_ti33x.sh', d)}"

SRC_URI += "\
    file://${QT_ENV} \
    ${@base_contains('DISTRO_FEATURES', 'wayland', '', "${QT_EGLFS_PATCHES}", d)}\
    file://0001-deform-Fix-how-controls-are-shown.patch \
    file://0002-deform-disable-opengl-button.patch \
"

python do_patch_append() {
    import shutil

    work_dir = d.getVar("WORKDIR", True)
    s = d.getVar("S", True)

    if not oe.utils.contains('DISTRO_FEATURES','wayland',True,False,d):
        shutil.copy(os.path.join(work_dir,"quit.png"),os.path.join(s,"examples/widgets/animation/animatedtiles/images/"))
}

# Add custom Arago Qt 5 Environment script file
do_install_append () {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/${QT_ENV} ${D}${sysconfdir}/profile.d/qt_env.sh
}

PACKAGES =+ "${PN}-conf"

FILES_${PN}-conf = "${sysconfdir}/profile.d/qt_env.sh"

RDEPENDS_${PN} += "${PN}-conf"
