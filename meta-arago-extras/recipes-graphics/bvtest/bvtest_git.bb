DESCRIPTION = "This is a bltsville userspace test application used to test \
the sanity of bltsville implementation"

HOMEPAGE = "https://git.ti.com/bvtest/bvtest"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=fc5539100b9be986fce191b19d2a48ae"
DEPENDS = "bltsville libdrm"

inherit autotools pkgconfig

PR = "r0"
SRCREV = "67e76ddf08703bd157935f666030c74a370b2836"

SRC_URI = "git://git.ti.com/bvtest/bvtest.git;protocol=git"

S = "${WORKDIR}/git"


do_compile() {
    export CC_PATH=${TOOLCHAIN_PATH}  
    export CROSS_COMPILE=${TOOLCHAIN_PREFIX}
    export BLTSVILLESEARCHPATH=${STAGING_DIR_TARGET}/usr
    cd ${S}/src/bvtest
    make -f makefile.linux  
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/src/bvtest/bvtest ${D}${bindir}
}
