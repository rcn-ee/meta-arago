DESCRIPTION = "Barcode demo to detect region of interest"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://detect_barcode.cpp;beginline=1;endline=25;md5=babab64d39715b3671dd16bcb4f4917b"

inherit features_check

REQUIRED_MACHINE_FEATURES = "dsp"
REQUIRED_DISTRO_FEATURES = "opencv"

DEPENDS += "opencv"

PV = "01.00.00"
PR = "r1"

BRANCH = "master"
SRC_URI = "git://git.ti.com/apps/barcode-roi-detection.git;protocol=git;branch=${BRANCH}"

SRCREV = "50fa051f66012ebaa10eba1cb289287c4c5e7432"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${S}/detect_barcode ${D}${bindir}

    install -d ${D}${datadir}/ti/image
    install -m 644 ${S}/test/sample_barcode.jpg ${D}${datadir}/ti/image
}

FILES:${PN} += "\
    ${datadir}/ti/image \
"

INSANE_SKIP:${PN} = "ldflags"
