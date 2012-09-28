DESCRIPTION = "OPP Server"
DEPENDS = "openobex bluez4"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://oppserver.c;beginline=1;endline=37;md5=c0ee352b095c583115f6600c1b4a3f60"

PR = "r0"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/803/5450/oppserver.tar.gz"

S = "${WORKDIR}"

do_install() {
	oe_runmake 'DEST_DIR=${D}' 'BIN_DIR=${bindir}' install
}

SRC_URI[md5sum] = "a73b39e9e17153aad488de0f9a25f926"
SRC_URI[sha256sum] = "c6c4c6c54c1ca6a54b8212e51aa0a2748cebd0c67b1b3560802348fb83b8748e"
