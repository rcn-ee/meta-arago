LICENSE="GPLv2"
DESCRIPTION = "Sysrepo based repo to configure EST"
LIC_FILES_CHKSUM = "file://nw-configurator.c;md5=a818a6cf4fbeeb21acc8b4e9956c08a4"

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
