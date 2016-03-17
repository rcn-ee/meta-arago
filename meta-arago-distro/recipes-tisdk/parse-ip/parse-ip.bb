DESCRIPTION = "Script to parse ip address during boot and make it available to the host system using shared partitions"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://init;beginline=3;endline=31;md5=fc4b04a33df6d892c9f4d4a9d92b945e"

COMPATIBLE_MACHINE = "ti33x|ti43x|keystone"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://init"

PR = "r4"

S = "${WORKDIR}"

INITSCRIPT_NAME = "parse-ip"
INITSCRIPT_PARAMS = "defaults 98"

inherit update-rc.d

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/parse-ip
}

FILES_${PN} = "${sysconfdir}"
