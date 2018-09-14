require recipes-bsp/u-boot/u-boot-ti-staging_${PV}.bb

PROVIDES = ""
PKG_${PN} = "${PN}"
PKG_${PN}-dev = "${PN}-dev"
PKG_${PN}-dbg = "${PN}-dbg"

COMPATIBLE_MACHINE = "k3"

SYSFW_VER = "2018.08b"
SYSFW_TISCI_am65xx-evm = "ti-sci-firmware-am65x-gp.bin"
SYSFW_BINARY = "sysfw.bin"
SYSFW_IMAGE = "sysfw-${SYSFW_VER}.bin"

SRCREV_sysfw = "463b1b4a50e8e361fa333f87caf74d2e05bc0a82"
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
EXTRA_OEMAKE += 'SYSFW=${WORKDIR}/${SYSFW_BINARY}'

UBOOT_BINARY = "tiboot3.bin"
UBOOT_IMAGE = "tiboot3-${MACHINE}-${PV}-${PR}.bin"
UBOOT_SYMLINK = "tiboot3-${MACHINE}.bin"
SPL_BINARY_k3 = ""

do_configure_append() {
	${WORKDIR}/gen_x509_cert.sh -m rom -c m3 -b ${WORKDIR}/fw/ti-sysfw/${SYSFW_TISCI} -o ${WORKDIR}/${SYSFW_BINARY} -l 0x40000
}

do_install_append() {
	install -m 644 ${WORKDIR}/${SYSFW_BINARY} ${D}/boot/${SYSFW_IMAGE}
	ln -sf ${SYSFW_IMAGE} ${D}/boot/${SYSFW_BINARY}
}

do_deploy_append() {
	install -m 644 ${WORKDIR}/${SYSFW_BINARY} ${DEPLOYDIR}/${SYSFW_IMAGE}
	rm -f ${DEPLOYDIR}/${SYSFW_BINARY}
	ln -sf ${SYSFW_IMAGE} ${DEPLOYDIR}/${SYSFW_BINARY}
}
