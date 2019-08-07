SUMMARY = "TI SCI firmware"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE.ti;md5=b5aebf0668bdf95621259288c4a46d76"

DEPENDS = "openssl-native u-boot-mkimage-native dtc-native"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "k3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

TI_SECURE_DEV_PKG ?= ""
export TI_SECURE_DEV_PKG

SRCREV = "3f7c97c9f923f6fbf1b96dcae1da8620a3bab0b3"
BRANCH ?= "ti-linux-firmware"
SRCREV_imggen = "1ee2d5d8476bcab79edf04778d5ae5db4ef291e3"
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

SRC_URI[hs-cert.md5sum] = "e36d9d945b4aa20347470c7c53dbc54a"
SRC_URI[hs-cert.sha256sum] = "e32182a3b36e5fc9543ca920dafcc2163384e116c88e3c2625399bc1c2ad2f45"
SRC_URI[hs-enc.md5sum] = "735128f2ac0dafdd44529f243b60a0c6"
SRC_URI[hs-enc.sha256sum] = "46c2870e133058f68d6b25fd4979a0726b7c6e2a100d48431d47e47db4165c75"

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
