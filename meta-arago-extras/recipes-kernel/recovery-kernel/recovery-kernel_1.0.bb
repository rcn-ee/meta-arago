DESCRIPTION = "Recovery kernel building for Keystone EVM"
LICENSE = "GPLv2"

# recovery kernel needs devtree compiler to add padding bytes
DEPENDS += "dtc-native"

PR = "r4"
COMPATIBLE_MACHINE = "keystone"
BRANCH = "v3.10.72/master"
SRCREV = "b9bad8fccc5f9c6bcd78363982b3249a15f193fb"
SRC_URI = "git://git.ti.com/keystone-linux/linux.git;protocol=git;branch=${BRANCH}"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

FILES_${PN} += "${bindir}/crashdump"
LINUX_ZIMAGE = "zImage"
KERNEL_MACHINE ?= "keystone2_recovery_defconfig"
KERNEL_DTBTYPE = "k2hk-evm-recovery.dtb k2l-evm-recovery.dtb k2e-evm-recovery.dtb "
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
        for d in ${KERNEL_DTBTYPE}
        do
            dtc -I dtb -O dtb -p 2048 -o $d arch/arm/boot/dts/$d
        done
}

do_install () {
	install -d ${D}${bindir}/${CRASHDIR}/
	install ${S}/arch/arm/boot/${LINUX_ZIMAGE} ${D}${bindir}/${CRASHDIR}
        for d in ${KERNEL_DTBTYPE}
        do
            install ${S}/$d ${D}${bindir}/${CRASHDIR}
        done
}
