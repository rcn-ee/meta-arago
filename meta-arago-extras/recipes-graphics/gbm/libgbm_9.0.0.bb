DESCRIPTION = "Userspace interface for the kernel GBM services."
HOMEPAGE = "http://git.ti.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://gbm.c;beginline=1;endline=26;md5=b871c7f2f477df29ee4c0ec437b187f7"
DEPENDS = "libdrm"

inherit autotools pkgconfig

SRCREV = "cb86a2f2cecd41023bf1bf12fbcf11be11220f31"

SRC_URI = "git://git.ti.com/glsdk/libgbm.git;protocol=git"

S = "${WORKDIR}/git"
