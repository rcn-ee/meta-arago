SUMMARY = "Statistics collector application"

LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bb6bc27cd44417c389a180bd62f552a0"

PROTOCOL = "git"
BRANCH = "master"
SRCREV = "dd0131eadf3633e8f9d06cb390d3c6c1b074d873"
SRC_URI = "git://git.ti.com/glsdk/statcol.git;protocol=${PROTOCOL};branch=${BRANCH}"

DEPENDS = "ti-rpmsg-char websocketd"
RDEPENDS:${PN} = "bash"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "SYSROOT=${STAGING_DIR_TARGET} CROSS_COMPILE=${TARGET_PREFIX}"

do_install() {
	DESTDIR=${D} make install
}

PR:append = "_3"

INSANE_SKIP:${PN} = "ldflags"
