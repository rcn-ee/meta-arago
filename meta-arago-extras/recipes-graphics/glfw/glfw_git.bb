SUMMARY = "GLFW cross platform graphics framework"
DESCRIPTION = "A multi-platform library for OpenGL and OpenGLES, window and input"
HOMEPAGE = "http://glfw.org/"
LICENSE = "Zlib & Libpng"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=90c6dd54408744b0f8a55f2a6c7ad870"

PV = "3.2.1+git${SRCPV}"
PR = "r0"

BRANCH = "master"
SRC_URI = "git://github.com/glfw/glfw.git;branch=${BRANCH}"
SRCREV = "0a3c4f5d80b041ee1a12c8da3503653d98bd1a15"

SRC_URI += "file://0001-HACK-CMakeList.txt-remove-check-for-Wayland-Egl-prov.patch"

DEPENDS = "extra-cmake-modules glib-2.0 virtual/libgles2 virtual/egl weston wayland wayland-native wayland-protocols"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DGLFW_USE_WAYLAND=ON -DGLFW_BUILD_EXAMPLES=OFF -DGLFW_BUILD_TESTS=OFF"

FILES_${PN}-dev += "${libdir}/cmake"
