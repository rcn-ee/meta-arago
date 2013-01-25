DESCRIPTION = "Texas Instruments Pinmux Utility"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b328fcf0477d688d8b85f7310f9e6b9"
COMPATIBLE_MACHINE = "am335x-evm|am37x-evm|am3517-evm|beagleboard"

PR = "r0"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/850/5562/PinMuxUtility_v2_04_01_00.zip;name=base;subdir=${P}"

# Temporarily add LICENSE file here since zip files don't contain any license information. This file was grabbed
# from the License Agreement screen when installing this application.
SRC_URI += "file://LICENSE"

SRC_URI[base.md5sum] = "f65ec03bbbb9e14126ac8ce2795acede"
SRC_URI[base.sha256sum] = "a95fe1b436419bf97bfdcc0b7ce95e497558ad81190d95dc0869ef9fc794094c"

S = "${WORKDIR}/${P}"

do_unpack_extra() {
    mv ${WORKDIR}/LICENSE ${WORKDIR}/${P}
}

addtask unpack_extra after do_unpack before do_patch

installdir = "host-tools/pinmux_utils/windows"

do_install() {
    install -d ${D}/${installdir}
    install ${S}/Pin_Mux_Utility.msi ${D}/${installdir}
    install ${S}/setup.exe ${D}/${installdir}
    install ${S}/Release_Notes.txt ${D}/${installdir}
}

FILES_${PN} += "${installdir}/*"
