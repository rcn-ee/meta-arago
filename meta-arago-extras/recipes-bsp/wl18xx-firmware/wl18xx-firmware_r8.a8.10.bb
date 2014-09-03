DESCRIPTION = "Firmware files for use with TI wl18xx"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENCE;md5=4977a0fe767ee17765ae63c435a32a9e"

PACKAGE_ARCH = "all"

PR = "r3+gitr${SRCPV}"

PROVIDES += "wl12xx-firmware"
RPROVIDES_${PN} += "wl12xx-firmware"
RREPLACES_${PN} += "wl12xx-firmware"
RCONFLICTS_${PN} += "wl12xx-firmware"

# Tag: ol_r8.a8.10
SRCREV = "89dc93a5c23fd69ebacd64c936ba5aabf173c29b"
SRC_URI = "git://github.com/TI-OpenLink/wl18xx_fw.git;protocol=git;branch=mbss \
           file://0001-Add-Makefile-for-SDK.patch \
          "

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    oe_runmake 'DEST_DIR=${D}' install
}

FILES_${PN} = "/lib/firmware/ti-connectivity/*"
