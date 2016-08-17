SUMMARY = "GLFW cross platform graphics framework"
DESCRIPTION = "A multi-platform library for OpenGL and OpenGLES, window and input"
HOMEPAGE = "http://glfw.org/"
LICENSE = "Zlib & Libpng"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=352912f8ce21ff7d8b592a4edbe48f50"

PV = "3.2"
PR = "r0"

BRANCH = "master"
SRC_URI = "git://github.com/glfw/glfw.git;branch=${BRANCH}"
SRCREV = "f6ec835599123c3c970d34534ed7ddc69a1fc6af"

SRC_URI += "file://0001-add-PKG_CONFIG_SYSROOT_DIR-prefix-for-WaylandProtocols_PKGDATADIR.patch"

DEPENDS = "extra-cmake-modules glib-2.0 virtual/libgles2 virtual/egl weston wayland wayland-native wayland-protocols"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DGLFW_USE_WAYLAND=ON -DGLFW_BUILD_EXAMPLES=OFF -DGLFW_BUILD_TESTS=OFF"

FILES_${PN} += "/usr/lib/cmake/*"
