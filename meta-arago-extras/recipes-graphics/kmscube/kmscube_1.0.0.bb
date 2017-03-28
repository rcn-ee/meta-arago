DESCRIPTION = "Demo application to showcase 3D graphics on SGX using kms and gbm"
HOMEPAGE = "http://git.ti.com"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://kmscube.c;beginline=1;endline=23;md5=e760965096e52da8f3969dd53b6bf158"

DEPENDS = "libdrm libgbm ti-sgx-ddk-um"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

PR = "r5"
SRCREV = "0fa27a594fd3290644f5666eac62dc570f26f866"

SRC_URI = "git://git.ti.com/glsdk/kmscube.git;protocol=git"

S = "${WORKDIR}/git"

INSANE_SKIP_kmscube += "dev-deps"
