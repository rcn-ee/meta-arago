DESCRIPTION = "Firmware files for use with TI wl18xx"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENCE;md5=4977a0fe767ee17765ae63c435a32a9e"

inherit allarch

PV = "R8.5+git${SRCPV}"

PR = "r6"

PROVIDES += "wl12xx-firmware"
RPROVIDES_${PN} += "wl12xx-firmware"
RREPLACES_${PN} += "wl12xx-firmware"
RCONFLICTS_${PN} += "wl12xx-firmware"

# Tag: R8.5
SRCREV = "02df01f8b9557b2cf920d14bdaaabde2373e3d7e"
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
