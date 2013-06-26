DESCRIPTION = "ARM Benchmarks"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_benchmarks/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aefb5e1cffc7b6a3ef18b803f957922"
SECTION = "system"

PR = "r6"

BRANCH ?= "master"
SRCREV = "eba9e69247c105f6d8dbcb56452ad4c4ea2df31e"

SRC_URI = "git://gitorious.org/arm_benchmarks/arm_benchmarks.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile() {

	export CROSS_COMPILE=${TARGET_PREFIX}
	export CFLAGS='${TARGET_CC_ARCH}'
	# build the release version
	oe_runmake release
}
do_install() {

	oe_runmake DESTDIR=${D} install
}

