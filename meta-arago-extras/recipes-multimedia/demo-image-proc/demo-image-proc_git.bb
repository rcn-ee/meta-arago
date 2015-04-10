DESCRIPTION = "TI Image Processing Demo for KeyStone 2"
HOMEPAGE = "http://git.ti.com/cgit/cgit.cgi/keystone-demos/image-proc.git"
LICENSE = "BSD & MIT"
LIC_FILES_CHKSUM = "file://Makefile;beginline=1;endline=29;md5=ada2acff673fad7c53cbfd2598525f2a"
SECTION = "console"
COMPATIBLE_MACHINE = "keystone"

DEPENDS = "ti-ipc"

BRANCH = "master"
SRC_URI = "git://git.ti.com/keystone-demos/image-proc.git;protocol=git;branch=${BRANCH}"
#Commit corresponds to DEV.DEMO_IMAGE_PROC-01.00.00.02B
SRCREV = "08d69947cea192328213bb91d52c43b403d3a36f"
PV = "1.0.0.2"

S = "${WORKDIR}/git"

MATRIX_BASE_DIR = "${datadir}/matrix-gui-2.0"
MATRIX_WEB_DIR = "${MATRIX_BASE_DIR}"
MATRIX_APP_DIR = "${MATRIX_WEB_DIR}/apps"
MATRIX_IPD_DIR = "${MATRIX_APP_DIR}/demo_imageproc"
MATRIX_CGI_DIR = "${MATRIX_IPD_DIR}/cgi-bin"

FILES_${PN} = "${MATRIX_IPD_DIR}/demo_imageproc.html"
FILES_${PN} += "${MATRIX_CGI_DIR}/image_processing_master.out"

do_install() {
	install -d ${D}${MATRIX_IPD_DIR}
	install -d ${D}${MATRIX_CGI_DIR}
	install -c -m 755 ${S}/ipc/master/image_processing_master.out ${D}${MATRIX_CGI_DIR}
	install -c -m 755 ${S}/webpage/demo_imageproc.html ${D}${MATRIX_IPD_DIR}
}
