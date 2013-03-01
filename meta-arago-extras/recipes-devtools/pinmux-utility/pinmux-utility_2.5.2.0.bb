DESCRIPTION = "Texas Instruments Pinmux Utility"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d69a4aafe4f7b66d5f9c60d6875ebd52"
COMPATIBLE_MACHINE = "am335x-evm|am37x-evm|am3517-evm|beagleboard"

PR = "r0"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/1019/6393/PinMuxUtility_v2_05_02_00.zip;name=base;subdir=${P}"

SRC_URI[base.md5sum] = "5a5cb5e9a5361fcb244a4b685872fe6b"
SRC_URI[base.sha256sum] = "93b8dfd726dd614aad9c2b0bb9ffc0abbd47e1c2900c3f411be7433c6d04fd2a"

S = "${WORKDIR}/${P}"

installdir = "host-tools/pinmux_utils/windows"

do_install() {
    install -d ${D}/${installdir}
    install ${S}/Pin_Mux_Utility.msi ${D}/${installdir}
    install ${S}/setup.exe ${D}/${installdir}
    install ${S}/Release_Notes.txt ${D}/${installdir}
}

FILES_${PN} += "${installdir}/*"
