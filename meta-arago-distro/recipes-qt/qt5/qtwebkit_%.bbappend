FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://GraphicsSurfaceGL_NoX.cpp.patch \
	file://0001-WebCore-PlatformQt.cmake-Fix-no-x11-build.patch \
"

PR_append = ".arago9"

EXTRA_OECMAKE_append = " -DCMAKE_BUILD_TYPE=Release"

EXTRA_OECMAKE_append_k3 = " -DUSE_SYSTEM_MALLOC=ON"

DEPENDS += "flex-native bison-native"
