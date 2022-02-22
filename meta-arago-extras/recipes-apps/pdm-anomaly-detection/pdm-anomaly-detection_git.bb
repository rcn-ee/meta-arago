SUMMARY = "Predictive maintenance demo for anomaly detection using Recurrent Neural Network (RNN)"
LICENSE = "BSD-3-Clause & MIT & GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e88016d2cbc82d0d2efbb0865891e9d6"

inherit qt5

PV = "1.0"
PR = "r2"

BRANCH = "master"
SRC_URI  = "git://git.ti.com/apps/pdm-anomaly-detection.git;protocol=git;branch=${BRANCH}"

SRCREV = "2ccf0e5e5aaac73166d52374650a25652bd6aed2"

S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative qtcharts"

do_install() {
    install -d ${D}${datadir}/ti/examples/pdm
    install -m 755 RnnPdmAnomalyDetection ${D}${datadir}/ti/examples/pdm
    install -m 644 ${S}/coeff.bin ${D}${datadir}/ti/examples/pdm
    install -m 644 ${S}/logs/* ${D}${datadir}/ti/examples/pdm
}

FILES_${PN} += "${datadir}/ti/examples/pdm"
