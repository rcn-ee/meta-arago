DESCRIPTION = "Initscripts for kdump recovery mechanism"
LICENSE = "BSD-3-Clause"

COMPATIBLE_MACHINE = "keystone"
LIC_FILES_CHKSUM = "file://recoveryfs.sh;beginline=1;endline=20;md5=83e9f5412fd9a0db2aee516b52c24535"
PR ="r1"

S = "${WORKDIR}"
SRC_URI = "file://recoveryfs.sh"

INITSCRIPT_NAME = "recoveryfs.sh"
INITSCRIPT_PARAMS = "defaults 10"

inherit update-rc.d

do_install_append() {
        install -d ${D}${sysconfdir}/init.d/
        install -c -m 755 ${WORKDIR}/recoveryfs.sh ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}
