DESCRIPTION = "ARM Benchmarks"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_benchmarks/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aefb5e1cffc7b6a3ef18b803f957922"
SECTION = "system"

PR = "r9"

BRANCH ?= "master"
SRCREV = "b3997516aee27d46ce1f59796af82ddbf06d20f4"

SRC_URI = "git://git.ti.com/apps/arm_benchmarks.git;protocol=git;branch=${BRANCH}"

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

