SUMMARY = "Statistics collector application"

LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bb6bc27cd44417c389a180bd62f552a0"

PROTOCOL = "git"
BRANCH = "master"
SRCREV = "6420b4e6d98dc2c6825557d7d6f56ffd52fd230c"
SRC_URI = "git://git.ti.com/glsdk/statcol.git;protocol=${PROTOCOL};branch=${BRANCH}"

DEPENDS = "ti-rpmsg-char websocketd"
RDEPENDS_${PN} = "bash"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "SYSROOT=${STAGING_DIR_TARGET} CROSS_COMPILE=${TARGET_PREFIX}"

do_install() {
	DESTDIR=${D} make install
}
