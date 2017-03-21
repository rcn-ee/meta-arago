DESCRIPTION = "Texas Instruments Pinmux Utility"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b328fcf0477d688d8b85f7310f9e6b9"
COMPATIBLE_MACHINE = "omapl138"

PR = "r0"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/461/4210/Pin_Setup_AM18xx_01_00_1076_03.zip;name=base;subdir=${P}"

# Temporarily add LICENSE file here since zip files don't contain any license information. This file was grabbed
# from the License Agreement screen when installing pinmux-utility_2.3.1.0. No license information exist for this
# version of the pinmux utility.
SRC_URI += "file://LICENSE"

SRC_URI[base.md5sum] = "5a4eb834bde44c662aaf669882adbfe6"
SRC_URI[base.sha256sum] = "6701ca0e91761b9eb80b0097fbb2e2ce2cd8e0bcdc0bd18c34cd0221d9d450d0"

S = "${WORKDIR}/${P}"

do_unpack_extra() {
    mv ${WORKDIR}/LICENSE ${WORKDIR}/${P}
}

addtask unpack_extra after do_unpack before do_patch

installdir = "host-tools/pinmux_utils/windows"

do_install() {
    install -d ${D}/${installdir}
    cp -rf ${S}/bin ${D}/${installdir}/
    cp -rf ${S}/configurations ${D}/${installdir}/
}

FILES_${PN} += "${installdir}/*"
