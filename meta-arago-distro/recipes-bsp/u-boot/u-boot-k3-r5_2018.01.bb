require recipes-bsp/u-boot/u-boot-ti-staging_${PV}.bb

PROVIDES = ""
PKG_${PN} = "${PN}"
PKG_${PN}-dev = "${PN}-dev"
PKG_${PN}-dbg = "${PN}-dbg"

COMPATIBLE_MACHINE = "k3"

SYSFW_VER = "2018.07"
SYSFW_BIN_am65xx-evm = "ti-sci-firmware-am6x-gp.bin"
SYSFW_DL_am65xx-evm = "ti-sci-firmware-am6x-gp-${SYSFW_VER}.bin"

SRC_URI += " \
	file://gen_x509_cert.sh \
	http://lcpd.gt.design.ti.com/sysfw/${SYSFW_VER}/${SYSFW_BIN};name=sysfw;downloadfilename=${SYSFW_DL}"

SRC_URI[sysfw.md5sum] = "368fc9e9b2113b0d25bae901d521c638"
SRC_URI[sysfw.sha256sum] = "7ed6262ce8a1171eb10a89845d6007ea5e54d80647c6af57434d10d4ded8d80b"

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
	${WORKDIR}/gen_x509_cert.sh -m rom -c m3 -b ${WORKDIR}/${SYSFW_DL} -o ${WORKDIR}/sysfw.bin -l 0x40000
}

do_install_append() {
	install -m 644 ${WORKDIR}/sysfw.bin ${D}/boot/
}

do_deploy_append() {
	install -m 644 ${WORKDIR}/sysfw.bin ${DEPLOYDIR}/
}
