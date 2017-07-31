DESCRIPTION = "Demo application to showcase 3D graphics on SGX using kms and gbm"
HOMEPAGE = "http://git.ti.com"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://kmscube.c;beginline=1;endline=23;md5=e760965096e52da8f3969dd53b6bf158"

DEPENDS = "libdrm libgbm ti-sgx-ddk-um"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

PR = "r8"
SRCREV = "24e94f583119896b3ab8ecc7b35c7de3160dcb1f"

SRC_URI = "git://git.ti.com/glsdk/kmscube.git;protocol=git"

SRC_URI_append = " \
"

S = "${WORKDIR}/git"

INSANE_SKIP_kmscube += "dev-deps"
