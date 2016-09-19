SUMMARY = "Cpuset is a Python application to make using the cpusets facilities in the Linux kernel easier"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "https://github.com/lpechacek/cpuset/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "6ad79b26ba03f559604d74513cc34392"
SRC_URI[sha256sum] = "32334e164415ed5aec83c5ffc3dc01c418406eb02d96d881fdfd495587ff0c01"

S = "${WORKDIR}/${P}"

CLEANBROKEN = "1"

inherit distutils
