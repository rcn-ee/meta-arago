SUMMARY = "TI SCI firmware"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE.ti;md5=b5aebf0668bdf95621259288c4a46d76"

DEPENDS = "openssl-native u-boot-mkimage-native dtc-native"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "k3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

TI_SECURE_DEV_PKG ?= ""
export TI_SECURE_DEV_PKG

SRCREV = "b41c4f097ab6f341462645f76059f48f78bbd17e"

BRANCH ?= "ti-linux-firmware"

SRCREV_imggen = "f68fe913c16f13a7e04f6f340de1c4f6cc561c10"
SRCREV_FORMAT = "imggen"

SRC_URI = " \
	git://git.ti.com/processor-firmware/ti-linux-firmware.git;protocol=git;branch=${BRANCH} \
	git://git.ti.com/processor-firmware/system-firmware-image-gen.git;protocol=git;branch=master;destsuffix=imggen;name=imggen \
"

# Please note, "install.source.dir.local" is not a real URL, files need to be pre-downloaded
SRC_URI_append_am65xx-hs-evm = " \
	http://install.source.dir.local/ti-sci-firmware-am65x-hs-cert.bin;name=hs-cert \
	http://install.source.dir.local/ti-sci-firmware-am65x-hs-enc.bin;name=hs-enc \
"

SRC_URI[hs-cert.md5sum] = "9c4de5577d92c83a467dad36ef04691b"
SRC_URI[hs-cert.sha256sum] = "262d4e4edc8eca996caaeefeb3d5daffe11d45d9499c6f71ad1a6a2fcf68aa97"
SRC_URI[hs-enc.md5sum] = "c851061ec96db61b601ad3685b1ecd23"
SRC_URI[hs-enc.sha256sum] = "73a17fd6ee2770d12ba328dd64009572b9ab0fbd4989111b34a7d67c5dfd2ca8"

S = "${WORKDIR}/git"

SYSFW_TISCI_am65xx-evm = "${S}/ti-sysfw/ti-sci-firmware-am65x-gp.bin"
SYSFW_TISCI_am65xx-hs-evm = "${WORKDIR}/ti-sci-firmware-am65x-hs-*.bin"
SYSFW_BINARY = "sysfw.itb"
SYSFW_IMAGE = "sysfw-${PV}.itb"

CROSS_COMPILE_V7 = "${@['${TARGET_SYS}-','${ELT_TARGET_SYS_ARMV7}-'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'linaro']}"
CROSS_COMPILE_V7 = "${@['${TARGET_SYS}-','${EAT_TARGET_SYS_ARMV7}-'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'arm']}"
PATH_prepend = "${TOOLCHAIN_PATH_ARMV7}/bin:"

EXTRA_OEMAKE = "CROSS_COMPILE=${CROSS_COMPILE_V7} SYSFW_DL_URL='' SYSFW_HS_DL_URL='' SYSFW_HS_INNER_CERT_DL_URL=''"
EXTRA_OEMAKE_append_am65xx-hs-evm = " HS=1"

do_compile() {
	cp ${SYSFW_TISCI} ${WORKDIR}/imggen/
	cd ${WORKDIR}/imggen/
	oe_runmake
}

do_install() {
	install -d ${D}/boot
	install -m 644 ${WORKDIR}/imggen/${SYSFW_BINARY} ${D}/boot/${SYSFW_IMAGE}
	ln -sf ${SYSFW_IMAGE} ${D}/boot/${SYSFW_BINARY}
}

FILES_${PN} = "/boot"

inherit deploy

do_deploy () {
	install -d ${DEPLOYDIR}
	install -m 644 ${WORKDIR}/imggen/${SYSFW_BINARY} ${DEPLOYDIR}/${SYSFW_IMAGE}
	rm -f ${DEPLOYDIR}/${SYSFW_BINARY}
	ln -sf ${SYSFW_IMAGE} ${DEPLOYDIR}/${SYSFW_BINARY}

	install -m 644 ${SYSFW_TISCI} ${DEPLOYDIR}/
}

addtask deploy before do_build after do_compile
