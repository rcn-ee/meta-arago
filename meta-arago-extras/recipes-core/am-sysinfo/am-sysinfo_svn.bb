DESCRIPTION = "AM SysInfo"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_sysinfo/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mem_util/mem_util.c;beginline=1;endline=37;md5=8aa8e714ab729cfe8177298af8a5a25d"

SECTION = "system"

PACKAGE_STRIP = "no"

SRCREV = "16"
PV = "1.0"
PR = "r2+svnr${SRCPV}"

SRC_URI = "svn://gforge.ti.com/svn/am_sysinfo/;module=trunk;proto=https;user=anonymous;pswd=''"

S = "${WORKDIR}/trunk"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -o mem_util/mem_util mem_util/mem_util.c
	${CC} ${CFLAGS} ${LDFLAGS} -o oprofile_example/Debug/signal_parent oprofile_example/signal_parent.c
	${CC} ${CFLAGS} -DUSE_SIGNALS ${LDFLAGS} -o oprofile_example/Debug1/signal_parent.opt oprofile_example/signal_parent.c
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/mem_util/mem_util ${D}/${bindir}
	install -m 0755 ${S}/oprofile_example/Debug/signal_parent ${D}/${bindir}
	install -m 0755 ${S}/oprofile_example/Debug1/signal_parent.opt ${D}/${bindir}
}
