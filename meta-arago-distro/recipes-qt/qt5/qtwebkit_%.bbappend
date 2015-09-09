FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://GraphicsSurfaceGL_NoX.cpp.patch \
	file://GraphicsSurfaceToken.h.patch \
	file://0001-Target.pri-update-to-use-GL_NoX-version-of-GraphicsS.patch \
	file://WebCore.pri.patch \
"

PR_append = "-arago4"
