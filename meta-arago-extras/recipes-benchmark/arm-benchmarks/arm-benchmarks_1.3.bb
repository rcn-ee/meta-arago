DESCRIPTION = "ARM Benchmarks"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_benchmarks/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aefb5e1cffc7b6a3ef18b803f957922"
SECTION = "system"

PR = "r3"

BRANCH ?= "master"
SRCREV = "e9fbf7990e93d97e7471e509626969d244cca214"

SRC_URI = "git://gitorious.org/arm_benchmarks/arm_benchmarks.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

PLATFORM_ARCH = "${ARMPKGARCH}"
# Use ARCH format expected by the makefile
PLATFORM_ARCH_omapl138 = "armv5te"

do_compile() {
	export CROSS_COMPILE=${TARGET_PREFIX}
	# build the release version
	make ARCH=${PLATFORM_ARCH} release
}

do_install() {
	make ARCH=${PLATFORM_ARCH} DESTDIR=${D} install
}
