SUMMARY = "bash-completions for opkg"
LICENSE = "MIT"

PR = "r1"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://opkg-bash-completion"

do_install() {
    install -d ${D}${datadir}/bash-completion/completions
    install -m 0644 ${WORKDIR}/opkg-bash-completion \
                    ${D}${datadir}/bash-completion/completions/opkg
}

FILES:${PN} = "${datadir}/bash-completion/completions/opkg"
RDEPENDS:${PN} = "bash-completion"
