FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

GLES_EXTRA_DEPS = "libdrm wayland"

PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"

PR:append = ".arago17"

QT_CONFIG_FLAGS += "-qpa ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', 'eglfs', d)}"

QT_EGLFS_PATCHES = "\
    file://0001-calculator-Add-exit-button-for-non-window-environmen.patch \
    file://0002-animatedtiles-Add-exit-button-for-non-window-environ.patch \
    file://quit.png \
"

#    file://0002-deform-disable-opengl-button.patch

SRC_URI += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', "${QT_EGLFS_PATCHES}", d)}\
    file://0001-deform-Fix-how-controls-are-shown.patch \
    file://0001-qtbase-plugins-platforms-eglfs_kms-fix-compiler-erro.patch \
    file://0001-eglfs-Force-888-format-only-on-env-flag.patch \
"

python do_patch:append() {
    import shutil

    work_dir = d.getVar("WORKDIR")
    s = d.getVar("S")

    if not bb.utils.contains('DISTRO_FEATURES','wayland',True,False,d):
        shutil.copy(os.path.join(work_dir,"quit.png"),os.path.join(s,"examples/widgets/animation/animatedtiles/images/"))
}

# Add symbolic link qt5/examples for backward compatibility
do_install:append () {

    install -d ${D}${datadir}/qt5
    ln -sf ../examples ${D}${datadir}/qt5/examples
}

FILES:${PN}-examples +=  "${datadir}/qt5/*"


RDEPENDS:${PN} += "${PN}-conf"
