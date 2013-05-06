DESCRIPTION = "AM SysInfo"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_sysinfo/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mem_util/mem_util.c;beginline=1;endline=37;md5=8aa8e714ab729cfe8177298af8a5a25d"

SECTION = "system"

PACKAGE_STRIP = "no"
PR = "r7"

BRANCH ?= "master"
SRCREV = "30c1dd8da089da41cac5686a0bebacc8950a8805"

SRC_URI = "git://gitorious.org/am_sysinfo/am_sysinfo.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"


do_compile() {
	export CROSS_COMPILE=${TARGET_PREFIX}
	export CFLAGS='${TARGET_CC_ARCH}'
	# build the release version
	oe_runmake release
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/mem_util/Release/mem_util ${D}/${bindir}
}
