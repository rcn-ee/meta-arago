DESCRIPTION = "Contains script to unshallow git repositories"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../unshallow-repositories.sh;beginline=3;endline=19;md5=234309914fd2cc17f3187bdb2d64553b"

SRC_URI = "file://unshallow-repositories.sh"

PR = "r0"

do_install () {
    install -d ${D}/
    install -d ${D}/bin
    install -m 0755 ${WORKDIR}/unshallow-repositories.sh ${D}/bin
}

FILES_${PN} = "/*"
