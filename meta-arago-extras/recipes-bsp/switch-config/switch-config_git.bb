DESCRIPTION = "Ethernet Switch configuration management"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://switch-config.c;beginline=1;endline=14;md5=659ff9658cbaba3110b81804af60de75"

DEPENDS = "virtual/kernel"

PV = "1.1"

BRANCH ?= "master"
SRCREV = "75791ba7f835530f2a10c889977d92e9175faa34"

SRC_URI = "git://git.ti.com/switch-config/switch-config.git;protocol=git;branch=${BRANCH} \
           file://0001-switch-config.c-include-stdbool.h-to-define-bool-typ.patch"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

do_configure() {
	mkdir -p ${S}/linux
	cp ${STAGING_KERNEL_DIR}/include/uapi/linux/net_switch_config.h ${S}/linux
	cp ${STAGING_KERNEL_DIR}/include/uapi/linux/sockios.h ${S}/linux
	sed 's|-I$(KBUILD_OUTPUT)/usr/include|${TOOLCHAIN_OPTIONS} -I.|' -i ${S}/Makefile
}

do_install() {
	install -d ${D}${bindir}/
	install -c -m 755 ${S}/switch-config ${D}${bindir}/switch-config
}
