FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#	file://GraphicsSurfaceToken.h.patch
#	file://0001-Target.pri-update-to-use-GL_NoX-version-of-GraphicsS.patch
#	file://WebCore.pri.patch

SRC_URI += " \
	file://GraphicsSurfaceGL_NoX.cpp.patch \
"

PR_append = ".arago6"

EXTRA_OECMAKE_append_k3 = " -DUSE_SYSTEM_MALLOC=ON"

DEPENDS += "flex-native bison-native"
