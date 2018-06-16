SUMMARY = "iperf is a widely used tool for network performance measurement and tuning"
HOMEPAGE = "https://sourceforge.net/projects/iperf2/"
SECTION = "console/network"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=e136a7b2560d80bcbf0d9b3e1356ecff"

SRC_URI = "${SOURCEFORGE_MIRROR}/iperf2/${BP}.tar.gz \
        file://0001-headers.h-include-stdbool.h-for-bool-definition.patch \
        file://0002-fix-bool-size-m4.patch \
"

SRC_URI[md5sum] = "c63766d275b4537f419db096b9dfe4dc"
SRC_URI[sha256sum] = "b7d650d07c6bb0e357b5938a20e4ac33876012fddb952299c5d321e6958da5d2"

S = "${WORKDIR}/${BP}"

inherit autotools pkgconfig

EXTRA_OECONF = "--exec-prefix=${STAGING_DIR_HOST}${layout_exec_prefix}"

PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'ipv6', 'ipv6', '', d)}"
PACKAGECONFIG[ipv6] = "--enable-ipv6,--disable-ipv6,"
