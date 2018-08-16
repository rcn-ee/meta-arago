require recipes-bsp/u-boot/u-boot-ti-staging_${PV}.bb

PROVIDES = ""
PKG_${PN} = "${PN}"
PKG_${PN}-dev = "${PN}-dev"
PKG_${PN}-dbg = "${PN}-dbg"

COMPATIBLE_MACHINE = "k3"

SYSFW_VER = "2018.07a"
SYSFW_BIN_am65xx-evm = "ti-sci-firmware-am6x-gp.bin"

SRCREV_sysfw = "2035022224dcc885ac2cd0b11f8c76190f5af962"
SYSFW_BRANCH = "ti-linux-firmware-4.1.y"
SRCREV_FORMAT = "sysfw"

SRC_URI += " \
	file://gen_x509_cert.sh \
	git://git.ti.com/processor-firmware/ti-linux-firmware.git;protocol=git;name=sysfw;branch=${SYSFW_BRANCH};destsuffix=fw"

CROSS_COMPILE_V7 = "${ELT_TARGET_SYS_ARMV7}-"
PATH_prepend = "${TOOLCHAIN_PATH_ARMV7}/bin:"

UBOOT_MACHINE_am65xx-evm = "am65x_evm_r5_defconfig"

EXTRA_OEMAKE = 'ARCH=arm CROSS_COMPILE=${CROSS_COMPILE_V7} CC="${CROSS_COMPILE_V7}gcc ${TOOLCHAIN_OPTIONS}" V=1'
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'
EXTRA_OEMAKE += 'SYSFW=${WORKDIR}/sysfw.bin'

UBOOT_BINARY = "tiboot3.bin"
UBOOT_IMAGE = "tiboot3-${MACHINE}-${PV}-${PR}.bin"
UBOOT_SYMLINK = "tiboot3-${MACHINE}.bin"
SPL_BINARY_k3 = ""

do_configure_append() {
	${WORKDIR}/gen_x509_cert.sh -m rom -c m3 -b ${WORKDIR}/fw/ti-sysfw/${SYSFW_BIN} -o ${WORKDIR}/sysfw.bin -l 0x40000
}

do_install_append() {
	install -m 644 ${WORKDIR}/sysfw.bin ${D}/boot/
}

do_deploy_append() {
	install -m 644 ${WORKDIR}/sysfw.bin ${DEPLOYDIR}/
}
