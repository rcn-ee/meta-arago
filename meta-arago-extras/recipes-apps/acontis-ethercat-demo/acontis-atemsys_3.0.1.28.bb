SUMMARY = "acontis atemsys kernel module for EtherCAT master"
HOMEPAGE = "https://www.acontis.com/en/ethercat-for-ti-processors.html"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=65dd37ccb3e888dc57e47d925b80b38a"

SRC_URI = "https://www.acontis.com/files/support/ethercat/EC-Master-Atemsys-V${PV}-Linux.tar.gz;subdir=${P}"
SRC_URI[md5sum] = "d8d92ae671c5cf78ae22bc5386d7f44f"
SRC_URI[sha256sum] = "dd3d83eb984b17b8378e0a5e5dfae8c77e25c5428a26319f59f44f805aff9e89"

COMPATIBLE_MACHINE = "am335x-evm|am57xx-evm"

PR = "r0"

S = "${WORKDIR}/${P}/yocto/meta-acontis/recipes-kernel/atemsys/files"

inherit module

EXTRA_OEMAKE += 'KERNELDIR="${STAGING_KERNEL_DIR}"'
