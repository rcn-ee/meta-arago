SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "4e2c848628425c572d8994ea96601d27543cd5fd"

SRC_URI = "git://github.com/nmav/cryptodev-linux.git;protocol=git"

EXTRA_OEMAKE='KERNEL_DIR="${STAGING_KERNEL_DIR}" PREFIX="${D}"'

S = "${WORKDIR}/git"
