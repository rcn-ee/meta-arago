DESCRIPTION = "ARM Benchmarks"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_benchmarks/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aefb5e1cffc7b6a3ef18b803f957922"
SECTION = "system"

PR = "r5"

BRANCH ?= "master"
SRCREV = "176c8869817913967ae1a0d561535eb40ba8a527"

SRC_URI = "git://gitorious.org/arm_benchmarks/arm_benchmarks.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

PLATFORM_ARCH = "${ARMPKGARCH}"
PLATFORM_ARCH_omapl138 = "armv5te"

do_compile() {
	export CROSS_COMPILE=${TARGET_PREFIX}
	export CFLAGS='${TARGET_CC_ARCH}'
	# build the release version
	oe_runmake -C ${PLATFORM_ARCH} release
}

do_install() {
	oe_runmake -C ${PLATFORM_ARCH} DESTDIR=${D} install
}
