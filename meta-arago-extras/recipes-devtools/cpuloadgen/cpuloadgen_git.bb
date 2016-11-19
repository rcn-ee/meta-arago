DESCRIPTION = "Utility to generate specified CPU Load"
HOMEPAGE = "https://github.com/ptitiano/cpuloadgen"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c6c2eb46c569d0cd7884089fea6b4f31"

PV = "0.93"
PR = "r1"

BRANCH ?= "master"
SRCREV ?= "301d69899d6f4d84f143e0ed86957eea416a27a6"

SRC_URI = "git://github.com/ptitiano/cpuloadgen.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "DESTDIR=${D}${bindir} CROSS_COMPILE=${TARGET_PREFIX} CC="${CC}""

do_install () {
    install -d ${D}${bindir}
    oe_runmake install
}
