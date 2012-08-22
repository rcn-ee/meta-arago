DESCRIPTION = "Linux Audio Video Example Applications"
HOMEPAGE = "https://gforge.ti.com/gf/project/av_examples/"
LICENSE = "BSD"
LIC_FILES_CHKSUM := "file://COPYING;md5=80ea1ff5788f65d5c5b3206d50d4bc6c"
SECTION = "system"
PRIORITY = "optional"

PR = "r0"

DEPENDS += "virtual/kernel"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(am37x-evm|am3517-evm)"

BRANCH ?= "master"
SRCREV = "ac75d09d29a805d89c49dd2741b79f3069e97827"

SRC_URI = "git://gitorious.org/av_examples/av_examples.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

# TODO: Export LDFLAGS from Rules.make to eliminate use of INSANE_SKIP which would otherwise lead to discrepancies between host and arago binaries
INSANE_SKIP_${PN} = "True"

do_compile() {
	touch debug
	export CROSS_COMPILE=${TARGET_PREFIX}
	make release LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" PLATFORM="${MACHINE}"
}

do_install() {
	make DESTDIR=${D} install
}
