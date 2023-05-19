SUMMARY = "Statistics collector application"

LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bb6bc27cd44417c389a180bd62f552a0"

PV = "1.0.4+git${SRCPV}"
PROTOCOL = "https"
BRANCH = "master"
SRCREV = "279bf455bc3dec69f374d46a8225687935f4323a"
SRC_URI = "git://git.ti.com/git/glsdk/statcol.git;protocol=${PROTOCOL};branch=${BRANCH}"

DEPENDS = "ti-rpmsg-char websocketd"
RDEPENDS:${PN} = "bash"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "SYSROOT=${STAGING_DIR_TARGET} CROSS_COMPILE=${TARGET_PREFIX}"

do_install() {
	DESTDIR=${D} make install
}

INSANE_SKIP:${PN} = "ldflags"
