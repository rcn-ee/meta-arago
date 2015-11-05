SUMMARY = "Cpuset is a Python application to make using the cpusets facilities in the Linux kernel easier"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "https://cpuset.googlecode.com/files/${P}.tar.gz"

SRC_URI[md5sum] = "50a0251c31990bb4ad63312e356ffcb5"
SRC_URI[sha256sum] = "800d9312bccb5b9802c04661464c6d8f14be8c677f68502e82558c6cb1b03413"

S = "${WORKDIR}/${P}"

CLEANBROKEN = "1"

inherit distutils
