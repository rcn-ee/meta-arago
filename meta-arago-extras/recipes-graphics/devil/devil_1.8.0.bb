SUMMARY = "DevIL cross platform image utility library"
DESCRIPTION = "Developer's Image Library (DevIL) is a cross-platform image \
               library utilizing simple syntax to load, save, convert, \
               manipulate, filter and display a variety of images."
HOMEPAGE = "https://github.com/DentonW/DevIL"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc178bcd425090939a8b634d1d6a9594"

SRC_URI = "git://github.com/dentonw/devil.git;protocol=https;branch=master \
           file://Remove-ILUT-dependency.patch"

SRCREV = "e34284a7e07763769f671a74b4fec718174ad862"

PR = "r1"
S = "${WORKDIR}/git"

# Build only DevIL
OECMAKE_SOURCEPATH = "${S}/DevIL"

PACKAGECONFIG ??= "png"
PACKAGECONFIG[png] = "-DIL_NO_PNG=0,-DIL_NO_PNG=1,libpng,"

inherit pkgconfig cmake
