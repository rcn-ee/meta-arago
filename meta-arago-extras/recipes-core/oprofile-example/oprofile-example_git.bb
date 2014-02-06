DESCRIPTION = "OProfile Example"
HOMEPAGE = "https://gitorious.org/oprofile-example"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://signal_parent.c;beginline=1;endline=37;md5=3c72149bb458105db5d2e6fbcb2da66e"

SECTION = "system"

INHIBIT_PACKAGE_STRIP = "1"

PR = "r3"

BRANCH ?= "master"
SRCREV = "066ecdab2bf0788eec253bf27fd44f7436f0cd04"

SRC_URI = "git://gitorious.org/oprofile-example/oprofile-example.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile() {
    install -d  ${S}/Debug
    install -d  ${S}/Debug1
	${CC} ${CFLAGS} ${LDFLAGS} -o Debug/signal_parent signal_parent.c
	${CC} ${CFLAGS} -DUSE_SIGNALS ${LDFLAGS} -o Debug1/signal_parent.opt signal_parent.c
}

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/Debug/signal_parent ${D}/${bindir}
	install -m 0755 ${S}/Debug1/signal_parent.opt ${D}/${bindir}
}
