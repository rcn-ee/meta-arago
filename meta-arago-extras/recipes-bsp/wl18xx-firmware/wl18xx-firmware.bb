DESCRIPTION = "Firmware files for use with TI wl18xx"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENCE;md5=4977a0fe767ee17765ae63c435a32a9e"

inherit allarch

PV = "R8.6+git${SRCPV}"

PR = "r7"

PROVIDES += "wl12xx-firmware"
RPROVIDES_${PN} += "wl12xx-firmware"
RREPLACES_${PN} += "wl12xx-firmware"
RCONFLICTS_${PN} += "wl12xx-firmware"

# Tag: R8.6
SRCREV = "c4c0c7943040473bd9aeba2ab9fa99617fa08a4b"
BRANCH = "ap_dfs"
SRC_URI = "git://git.ti.com/wilink8-wlan/wl18xx_fw.git;protocol=git;branch=${BRANCH} \
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
