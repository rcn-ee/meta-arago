DESCRIPTION = "Sysrepo based repo to configure EST"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://nw-configurator.c;beginline=1;endline=33;md5=3538caaf9bfb8372347877ad393660fa"

SRC_URI = "file://nw-configurator.c"

S = "${WORKDIR}"

FILES_${PN}-dev = "${includedir}"

DEPENDS = "sysrepo"

inherit autotools pkgconfig

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -I=${STAGING_INCDIR}	${WORKDIR}/nw-configurator.c -o nw-configurator -lsysrepo
}

BBCLASSEXTEND = "native nativesdk"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 nw-configurator ${D}${bindir}
}
