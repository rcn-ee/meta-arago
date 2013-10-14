FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://features.prf.patch \
	file://GraphicsContext3DQt.cpp.patch \
	file://GraphicsSurfaceGL_NoX.cpp.patch \
	file://GraphicsSurfaceToken.h.patch \
	file://OpenGLShims.cpp.patch \
	file://qttestbrowser.cpp.patch \
	file://Target.pri.patch \
	file://WebCore.pri.patch \
"

PR_append = "-arago0"
