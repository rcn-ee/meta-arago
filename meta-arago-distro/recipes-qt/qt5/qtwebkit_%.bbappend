FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

#	file://GraphicsSurfaceToken.h.patch
#	file://0001-Target.pri-update-to-use-GL_NoX-version-of-GraphicsS.patch
#	file://WebCore.pri.patch

SRC_URI += " \
	file://GraphicsSurfaceGL_NoX.cpp.patch \
	file://0001-HACK-ANGLE-khrplatform.h-add-define-MESA_EGL_NO_X11_.patch \
"

PR:append = ".arago8"

EXTRA_OECMAKE:append = " -DCMAKE_BUILD_TYPE=Release"

EXTRA_OECMAKE:append:k3 = " -DUSE_SYSTEM_MALLOC=ON"

DEPENDS += "flex-native bison-native"
