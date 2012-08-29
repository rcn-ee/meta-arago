DESCRIPTION = "AM SysInfo"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_sysinfo/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mem_util/mem_util.c;beginline=1;endline=37;md5=8aa8e714ab729cfe8177298af8a5a25d"

SECTION = "system"

PACKAGE_STRIP = "no"
PR = "r5"

BRANCH ?= "master"
SRCREV = "f2b325741ebcd440c4b2fc91a65270391224426e"

SRC_URI = "git://gitorious.org/am_sysinfo/am_sysinfo.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"


do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -o mem_util/mem_util mem_util/mem_util.c
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/mem_util/mem_util ${D}/${bindir}
}
