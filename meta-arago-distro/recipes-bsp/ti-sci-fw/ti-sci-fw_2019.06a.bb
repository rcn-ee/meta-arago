SUMMARY = "TI SCI firmware"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE.ti;md5=b5aebf0668bdf95621259288c4a46d76"

DEPENDS = "openssl-native u-boot-mkimage-native dtc-native"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "k3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

TI_SECURE_DEV_PKG ?= ""
export TI_SECURE_DEV_PKG

SRCREV = "ca194f3c597b3ebba9ceb032f13f1a4e7ffa5653"
BRANCH ?= "ti-linux-firmware"
SRCREV_imggen = "9fb15bf62e95787cd6505ca4ac9f982ea6de0623"
SRCREV_FORMAT = "imggen"

SRC_URI = " \
	git://git.ti.com/processor-firmware/ti-linux-firmware.git;protocol=git;branch=${BRANCH} \
	git://git.ti.com/processor-firmware/system-firmware-image-gen.git;protocol=git;branch=master;destsuffix=imggen;name=imggen \
"

# Please note, "install.source.dir.local" is not a real URL, below files need to be pre-downloaded
SRC_URI_append_am65xx-hs-evm = " \
	http://install.source.dir.local/ti-sci-firmware-am65x-hs-cert.bin;name=hs-cert \
	http://install.source.dir.local/ti-sci-firmware-am65x-hs-enc.bin;name=hs-enc \
"

SRC_URI[hs-cert.md5sum] = "9c4de5577d92c83a467dad36ef04691b"
SRC_URI[hs-cert.sha256sum] = "262d4e4edc8eca996caaeefeb3d5daffe11d45d9499c6f71ad1a6a2fcf68aa97"
SRC_URI[hs-enc.md5sum] = "c851061ec96db61b601ad3685b1ecd23"
SRC_URI[hs-enc.sha256sum] = "73a17fd6ee2770d12ba328dd64009572b9ab0fbd4989111b34a7d67c5dfd2ca8"

S = "${WORKDIR}/git"

SYSFW_SOC_am65xx = "am65x"
SYSFW_SOC_j7-evm = "j721e"
SYSFW_CONFIG = "evm"

SYSFW_PREFIX = "ti-sci-firmware"

SYSFW_BASE = "${SYSFW_PREFIX}-${SYSFW_SOC}-gp"
SYSFW_BASE_am65xx-hs-evm = "${SYSFW_PREFIX}-${SYSFW_SOC}-hs"

SYSFW_TISCI = "${S}/ti-sysfw/${SYSFW_BASE}.bin"
SYSFW_TISCI_am65xx-hs-evm = "${WORKDIR}/${SYSFW_BASE}-*.bin"

SYSFW_BINARY = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_IMAGE = "sysfw-${PV}.itb"
SYSFW_SYMLINK = "sysfw.itb"

CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

do_configure[noexec] = "1"

CROSS_COMPILE_V7 = "${@['${TARGET_SYS}-','${ELT_TARGET_SYS_ARMV7}-'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'linaro']}"
CROSS_COMPILE_V7 = "${@['${TARGET_SYS}-','${EAT_TARGET_SYS_ARMV7}-'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'arm']}"
PATH_prepend = "${TOOLCHAIN_PATH_ARMV7}/bin:"

EXTRA_OEMAKE = "\
    CROSS_COMPILE=${CROSS_COMPILE_V7} SYSFW_DL_URL='' SYSFW_HS_DL_URL='' SYSFW_HS_INNER_CERT_DL_URL='' \
    SYSFW_PATH="${SYSFW_TISCI}" SOC=${SYSFW_SOC} CONFIG=${SYSFW_CONFIG} \
"
EXTRA_OEMAKE_append_am65xx-hs-evm = " \
    HS=1 SYSFW_HS_PATH="${WORKDIR}/${SYSFW_BASE}-enc.bin" SYSFW_HS_INNER_CERT_PATH="${WORKDIR}/${SYSFW_BASE}-cert.bin" \
"

do_compile() {
	cd ${WORKDIR}/imggen/
	oe_runmake
}

do_install() {
	install -d ${D}/boot
	install -m 644 ${WORKDIR}/imggen/${SYSFW_BINARY} ${D}/boot/${SYSFW_IMAGE}
	ln -sf ${SYSFW_IMAGE} ${D}/boot/${SYSFW_SYMLINK}
}

FILES_${PN} = "/boot"

inherit deploy

do_deploy () {
	install -d ${DEPLOYDIR}
	install -m 644 ${WORKDIR}/imggen/${SYSFW_BINARY} ${DEPLOYDIR}/${SYSFW_IMAGE}
	rm -f ${DEPLOYDIR}/${SYSFW_SYMLINK}
	ln -sf ${SYSFW_IMAGE} ${DEPLOYDIR}/${SYSFW_SYMLINK}

	install -m 644 ${SYSFW_TISCI} ${DEPLOYDIR}/
}

addtask deploy before do_build after do_compile
