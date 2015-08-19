DESCRIPTION = "OpenGL headers required for OpenCL development"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://../GL/gl.h;startline=1;endline=24;md5=10424a07c8d8310e34ced799b95f0fb6"

ALLOW_EMPTY_${PN} = "1"

SRC_URI = " \
    file://GL/gl.h \
    file://GL/gl_mangle.h \
    file://GL/glext.h \
    file://GL/glx.h \
    file://GL/glx_mangle.h \
    file://GL/glxext.h \
    file://GL/osmesa.h \
    file://GL/wglext.h \
    file://GL/wmesa.h \
    file://GL/internal/dri_interface.h \
"

do_install() {
    install -d ${D}${includedir}/GL
    cp -r ${WORKDIR}/GL/* ${D}${includedir}/GL
}

