DESCRIPTION = "AM SysInfo"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_sysinfo/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mem_util/mem_util.c;beginline=1;endline=37;md5=8aa8e714ab729cfe8177298af8a5a25d"

SECTION = "system"

PACKAGE_STRIP = "no"
PR = "r8"

BRANCH ?= "master"
SRCREV = "7aa7e7a316d24c06c8e6a4931f7297f209dfd8e1"

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
