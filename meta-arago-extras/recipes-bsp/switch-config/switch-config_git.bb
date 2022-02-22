DESCRIPTION = "Ethernet Switch configuration management"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://switch-config.c;beginline=1;endline=14;md5=659ff9658cbaba3110b81804af60de75"

PV = "2.0"
PR = "r5"

BRANCH ?= "v4.1"
BRANCH:aarch64 ?= "am65x-v1.0"

SRCREV = "412dce4e65cfe5af729be38fd1b4c1d59e9a8828"
SRCREV:aarch64 = "0f52dcb3c4e3678e96427d546d6c2e1fabc2ad91"

SRC_URI = "git://git.ti.com/switch-config/switch-config.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} CC="${CC}""

do_configure() {
	sed 's|-I$(KBUILD_OUTPUT)/usr/include|${TOOLCHAIN_OPTIONS} -I.|' -i ${S}/Makefile
}

do_install() {
	install -d ${D}${bindir}/
	install -c -m 755 ${S}/switch-config ${D}${bindir}/switch-config
}
