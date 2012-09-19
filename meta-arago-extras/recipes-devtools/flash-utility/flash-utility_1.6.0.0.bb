DESCRIPTION = "Texas Instruments Flash Utility"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a428c464689fd2fac5b185963cbfbf85"

PR = "r0"

COMPATIBLE_MACHINE = "am37x-evm|am3517-evm"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/580/4785/Flash_v1.6.0.0.zip;name=base;subdir=${P}"

# Temporarily add LICENSE file here since zip files don't contain any license information. This file was grabbed
# from the License Agreement screen when installing the flash utility application.
SRC_URI += "file://LICENSE"

S = "${WORKDIR}/${P}"

do_unpack_extra() {
    mv ${WORKDIR}/LICENSE ${WORKDIR}/${P}
}

addtask unpack_extra after do_unpack before do_patch

installdir = "host-tools/flash_utils/windows"

do_install() {
    install -d ${D}/${installdir}
    install ${S}/setup.exe ${D}/${installdir}
    install ${S}/FlashInstaller.msi ${D}/${installdir}
    install ${S}/Release_Notes.txt ${D}/${installdir}
}

FILES_${PN} += "${installdir}/*"

SRC_URI[base.md5sum] = "1f53efa31996afb5af78930739090ae6"
SRC_URI[base.sha256sum] = "f6722422016ec4e49b8c55c38affea4c924b6636a47d0d67e6537e7dab108a1b"
