DESCRIPTION = "Demo application to showcase 3D graphics on SGX using kms and gbm"
HOMEPAGE = "http://git.ti.com"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://kmscube.c;beginline=1;endline=23;md5=e760965096e52da8f3969dd53b6bf158"

DEPENDS = "libdrm virtual/libgbm virtual/egl virtual/libgles2"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|k3"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

PR = "r13"
SRCREV = "456cabc661caac5c60729751d45efd668faa8e97"

SRC_URI = "git://git.ti.com/glsdk/kmscube.git;protocol=git"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"

INSANE_SKIP_kmscube += "dev-deps"
