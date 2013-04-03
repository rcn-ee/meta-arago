DESCRIPTION = "Package that will install a README file into the SDK prebuilt-binaries directory"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "\
    file://README \
"

PR = "r0"
PV = "1.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

do_install () {
    install -d ${D}/board-support/prebuilt-images

    install -m 0644 ${S}/README ${D}/board-support/prebuilt-images/
}

FILES_${PN} += "board-support/*"
