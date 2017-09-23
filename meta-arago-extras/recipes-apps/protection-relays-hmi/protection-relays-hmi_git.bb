SUMMARY = "HMI demo for Protection Relays using QT  tools"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=33;md5=a9cde3921a8be42ed79ab74661799104"

inherit qt-provider

PV = "1.0"
PR = "r0"

BRANCH = "master"
SRC_URI = "git://git.ti.com/sitara-linux/protection-relays-hmi.git;protocol=git;branch=${BRANCH}"

SRCREV = "b116b5628a68ba3b6db88435023cf034504655d3"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 755 protection_relays_hmi ${D}${bindir}
}
