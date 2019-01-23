SUMMARY = "Gesture baed HMI demo using mmWave IWR1642 chip and Sitara AM device"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=33;md5=e7e749ff1989b18db836e5d9910a37e9"

inherit qt-provider

PV = "1.0"
PR = "r0"

BRANCH = "master"
SRC_URI = "git://git.ti.com/sitara-linux/mmwavegesture-hmi.git;protocol=git;branch=${BRANCH}"

SRCREV = "0881fc8bc5b3c3411af7b69c3837a8b3a1fbedc5"

S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative qtserialport"

do_install() {
    install -d ${D}${bindir}
    install -m 755 mmwavegesture_hmi ${D}${bindir}
}
