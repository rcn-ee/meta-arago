DESCRIPTION = "Initscripts for kdump recovery mechanism"
LICENSE = "BSD-3-Clause"

COMPATIBLE_MACHINE = "keystone"
LIC_FILES_CHKSUM = "file://recoveryfs.sh;md5=e1cea7fe03a879dfe71592798e89ed0d"

S = "${WORKDIR}"
SRC_URI = "file://recoveryfs.sh"

INITSCRIPT_NAME = "recoveryfs.sh"
INITSCRIPT_PARAMS = "defaults 10"

inherit update-rc.d

do_install_append() {
        install -d ${D}${sysconfdir}/init.d/
        install -c -m 755 ${WORKDIR}/recoveryfs.sh ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}
