SUMMARY = "TIDL Utilities and configuration files"
DESCRIPTION = "TIDL Utilities for standalone simulation and importing / translation of Caffe and TF-Slim models"
HOMEPAGE = "http://software-dl.ti.com/processor-sdk-linux/esd/docs/latest/linux/Foundational_Components.html#tidl"
LICENSE = "TI-TFL"

require ./tidl-utils.inc

PV = "1.0.1.0"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://docs/LICENSE.txt;md5=a93aa5af7a3bbbb6fb34c8df59efaa5c"

RDEPENDS_${PN}_class-target += "tidl-api tidl-examples"

PR = "${INC_PR}.0"

S = "${WORKDIR}/git"

TARGET_class-target = "arm"
TARGET_class-native = "x86"
TARGET_class-nativesdk = "x86"

CP_ARGS = "-Prf --preserve=mode,timestamps --no-preserve=ownership"

do_install() {
  install -d ${D}${bindir}
  install -d ${D}${datadir}/ti/tidl/utils/test
  install -d ${D}${datadir}/ti/tidl/utils/docs
  install -m 755 ${S}/${TARGET}/bin/* ${D}${bindir}
  cp ${CP_ARGS} ${S}/test/* ${D}${datadir}/ti/tidl/utils/test/.
  cp ${CP_ARGS} ${S}/docs/* ${D}${datadir}/ti/tidl/utils/docs/.
}

FILES_${PN} += "${datadir}/ti/tidl/utils \
                ${bindir}"

BBCLASSEXTEND = "native nativesdk"

INSANE_SKIP_${PN} += "build-deps ldflags already-stripped"
