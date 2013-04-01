LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit allarch

PR ="r0"

SRC_URI = "file://wifi-direct-launcher.sh"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sbindir}
    install -m 755 ${WORKDIR}/wifi-direct-launcher.sh ${D}${sbindir}
}

FILES_${PN} = "/usr/sbin/wifi-direct-launcher.sh"
