DESCRIPTION = "Task to install crypto dev packages in SDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = "\
    openssl-dev \
    ocf-linux-dev \
"
