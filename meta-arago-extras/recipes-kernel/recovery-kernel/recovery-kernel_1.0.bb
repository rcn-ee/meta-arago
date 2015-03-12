DESCRIPTION = "Recovery kernel building for Keystone EVM"
LICENSE = "GPLv2"

PR = "r2"
COMPATIBLE_MACHINE = "keystone"
BRANCH = "master"
SRCREV = "9bc93706b37c39c3a95593dc3d56773e9b7425ad"
SRC_URI = "git://git.ti.com/keystone-linux/linux.git;protocol=git;branch=${BRANCH}"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

FILES_${PN} += "${bindir}/crashdump"
LINUX_ZIMAGE = "zImage"
KERNEL_MACHINE ?= "keystone2_recovery_defconfig"
KERNEL_DTBTYPE = "k2hk-evm-recovery.dtb"
CRASHDIR = "crashdump"
ARCH = "${TARGET_ARCH}"
CROSS_COMPILE = "${TARGET_PREFIX}"

export ARCH
export CROSS_COMPILE

do_configure () {
	make ${KERNEL_MACHINE}
}

do_compile() {
	make ${LINUX_ZIMAGE} KALLSYMS_EXTRA_PASS=1
	make ${KERNEL_DTBTYPE}
	dtc -I dtb -O dtb -p 2048 -o ${KERNEL_DTBTYPE} arch/arm/boot/dts/${KERNEL_DTBTYPE}
}

do_install () {
	install -d ${D}${bindir}/${CRASHDIR}/
	install ${S}/arch/arm/boot/${LINUX_ZIMAGE} ${D}${bindir}/${CRASHDIR}
	install ${S}/${KERNEL_DTBTYPE} ${D}${bindir}/${CRASHDIR}
}
