DESCRIPTION = "TI Image Processing Demo for KeyStone 2"
HOMEPAGE = "http://git.ti.com/cgit/cgit.cgi/keystone-demos/image-proc.git"
LICENSE = "BSD & MIT"
LIC_FILES_CHKSUM = "file://Makefile;beginline=1;endline=29;md5=ada2acff673fad7c53cbfd2598525f2a"
SECTION = "console"
COMPATIBLE_MACHINE = "keystone"

DEPENDS = "ti-ipc"

BRANCH = "master"
SRC_URI = "git://git.ti.com/keystone-demos/image-proc.git;protocol=git;branch=${BRANCH}"
#Commit corresponds to DEV.DEMO_IMAGE_PROC-01.00.00.03
SRCREV = "d1f4014d28ecedf34dbd20f04d4277eb1c4b8ae0"
PV = "1.0.0.3"

S = "${WORKDIR}/git"

FILES_${PN} = "${bindir}/image_processing_master"

do_install() {
	if [ ! -d ${D}/${bindir} ]
	then
		install -d ${D}${bindir}
	fi
	install -c -m 755 ${S}/ipc/master/image_processing_master.out ${D}${bindir}/image_processing_master
}
