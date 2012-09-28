DESCRIPTION = "Initialization and demo application for bluetooth on WL1271 chipset"
SECTION = "network"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README.md;md5=7fd458a478fbc8a473a2d5b95c5cb048"

DEPENDS += "openobex"
RDEPENDS += "bluez4 openobex ussp-push obexftp bluez-hcidump"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGE_STRIP = "no"

PR = "r0+gitr${SRCREV}"

SRCREV = "c7faa4cd2ef26b72ef2ae3d3d4854ea83a2ee636"

COMPATIBLE_MACHINE = "am37x-evm|am180x-evm|da850-omapl138-evm|am335x-evm"

SRC_URI = "git://github.com/TI-ECS/wl1271-bluetooth.git;protocol=git"

S = "${WORKDIR}/git"

PLATFORM_am37x-evm = "omap3evm"
PLATFORM_am180x-evm = "am1808"
PLATFORM_da850-omapl138-evm = "am1808"
PLATFORM_am335x-evm = "am335x"
PLATFORM ?= "UNKNOWN"

do_install () {
	install -d ${D}${datadir}/wl1271-demos
	install -d ${D}${datadir}/wl1271-demos/bluetooth
	install -d ${D}${datadir}/wl1271-demos/bluetooth/gallery
	install -d ${D}${datadir}/wl1271-demos/bluetooth/scripts
	install -d ${D}${datadir}/wl1271-demos/bluetooth/ftp_folder

	install -m 0755 ${S}/gallery/* ${D}${datadir}/wl1271-demos/bluetooth/gallery
	install -m 0755 ${S}/script/common/* ${D}${datadir}/wl1271-demos/bluetooth/scripts
	install -m 0755 ${S}/script/${PLATFORM}/* ${D}${datadir}/wl1271-demos/bluetooth/scripts
	install -m 0755 ${S}/ftp_folder/* ${D}${datadir}/wl1271-demos/bluetooth/ftp_folder
}

FILES_${PN} +=" \
	${datadir}/wl1271-demos/bluetooth/scripts \
	${datadir}/wl1271-demos/bluetooth/gallery \
	${datadir}/wl1271-demos/bluetooth/ftp_folder \
	"
