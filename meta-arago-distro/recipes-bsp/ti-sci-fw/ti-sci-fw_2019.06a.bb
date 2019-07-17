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
SRCREV_imggen = "ef6f0b61dbd32ddbef62fbe7a7e70241221a0461"
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

SRC_URI[hs-cert.md5sum] = "29eeb2ef5088626c2add8a25f8b9a420"
SRC_URI[hs-cert.sha256sum] = "c7185e4d95f8bd57e985d1c53c814e65bed078669e2270152e406e8d2a04a186"
SRC_URI[hs-enc.md5sum] = "e465a2328e042dd932b98d78d8f531de"
SRC_URI[hs-enc.sha256sum] = "6ecc456f2800a8937c6109c91bc4c62432c2aabad73ad6f3486a6457e22b087a"

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
