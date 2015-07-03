require ${COREBASE}/meta/recipes-qt/qt4/qt4-${PV}.inc
require ${COREBASE}/meta/recipes-qt/qt4/qt4-embedded.inc

PR = "${INC_PR}.3"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:${COREBASE}/meta/recipes-qt/qt4/qt4-${PV}:${COREBASE}/meta/recipes-qt/qt4/files:"

DEFAULT_PREFERENCE = "-1"

SRC_URI += " \
           file://0001-wsegl2-support.patch \
           file://002_pvrqwswsegl.c.patch \
           file://cursor-hack.diff \
"
SRC_URI_append_ti33x = " file://0001-Qt-4.x-v2-Changes-for-integrating-with-TI-graphics-S.patch"
SRC_URI_append_ti43x = " file://0001-Qt-4.x-v2-Changes-for-integrating-with-TI-graphics-S.patch"

QT_CONFIG_FLAGS_append_armv6 = " -no-neon "

QT_CONFIG_FLAGS += " \
 -exceptions \
"

QT_GLFLAGS = "-opengl es2 -depths 16,24,32 -plugin-gfx-powervr -D QT_QWS_CLIENTBLIT"

PROVIDES += "qt4-embedded"
RPROVIDES_${PN} += "qt4-embedded"
RPROVIDES_${PN}-dev += "qt4-embedded-dev"

DEPENDS += "virtual/egl"
