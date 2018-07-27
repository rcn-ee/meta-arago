require recipes-bsp/u-boot/u-boot-ti-staging_${PV}.bb

PROVIDES = ""
PKG_${PN} = "${PN}"
PKG_${PN}-dev = "${PN}-dev"
PKG_${PN}-dbg = "${PN}-dbg"

COMPATIBLE_MACHINE = "k3"

SYSFW_VER = "2018.06"
SYSFW_BIN_am65xx-evm = "ti-sci-firmware-am6x-gp.bin"

SRC_URI += " \
	file://gen_x509_cert.sh \
	http://lcpd.gt.design.ti.com/sysfw/${SYSFW_VER}/${SYSFW_BIN};name=sysfw"

SRC_URI[sysfw.md5sum] = "384a5240572a0c648a991326797fed05"
SRC_URI[sysfw.sha256sum] = "8a0ef9bc9d21510169e8d656d2872228a8f0e703b0b25437c227a42738d45579"

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
	${WORKDIR}/gen_x509_cert.sh -m rom -c m3 -b ${WORKDIR}/${SYSFW_BIN} -o ${WORKDIR}/sysfw.bin -l 0x40000
}

do_install_append() {
	install -m 644 ${WORKDIR}/sysfw.bin ${D}/boot/
}

do_deploy_append() {
	install -m 644 ${WORKDIR}/sysfw.bin ${DEPLOYDIR}/
}
