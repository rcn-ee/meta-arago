DESCRIPTION = "Stream Benchmark"
HOMEPAGE = "http://www.cs.virginia.edu/stream/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=bca8cbe07976fe64c8946378d08314b0"
SECTION = "system"

PR = "r0"

BRANCH ?= "master"
SRCREV = "bd474633b7b0352211b48d84065bf7b7e166e4c2"

SRC_URI = "git://git.ti.com/sitara-linux/stream.git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile() {
	# build the release version
	oe_runmake stream_linux
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/stream_c ${D}/${bindir}/
}
