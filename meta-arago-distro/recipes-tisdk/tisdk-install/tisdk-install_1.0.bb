DESCRIPTION = "Contains script to properly extract and update various files"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../sdk-install.sh;beginline=3;endline=19;md5=4b89903784b8d154cd8b631388da4f0d"

SRC_URI = "file://sdk-install.sh"

PR = "r3"

do_install () {
    install -d ${D}/
    install  ${WORKDIR}/sdk-install.sh ${D}/sdk-install.sh

}

FILES_${PN} = "/*"
