DESCRIPTION = "Demo application to showcase 3D graphics on SGX using kms and gbm"
HOMEPAGE = "http://git.ti.com"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://kmscube.c;beginline=1;endline=23;md5=e760965096e52da8f3969dd53b6bf158"

DEPENDS = "libdrm libgbm omap5-sgx-ddk-um-linux"

COMPATIBLE_MACHINE = "omap-a15"

inherit autotools pkgconfig

PR = "r2"
SRCREV = "1c8a0d26c5b1918432fd94d2ac9894b3dcdb2814"

SRC_URI = "git://git.ti.com/glsdk/kmscube.git;protocol=git"

S = "${WORKDIR}/git"

INSANE_SKIP_kmscube += "dev-deps"
