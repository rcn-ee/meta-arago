SUMMARY = "HMI demo for electronic vehicle charging station (EVSE) using QT QWidget tools"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=33;md5=a9cde3921a8be42ed79ab74661799104"

inherit qt-provider

PV = "1.0"
PR = "r1"

BRANCH = "master"
SRC_URI = "git://git.ti.com/git/sitara-linux/evse-hmi.git;protocol=https;branch=${BRANCH}"

SRCREV = "d8c309d2832735f8df84db9993a01d861fdc02d7"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 755 evse_hmi ${D}${bindir}
}
