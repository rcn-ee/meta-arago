SUMMARY = "TIDL Utilities and configuration files"
DESCRIPTION = "TIDL Utilities for standalone simulation and importing / translation of Caffe and TF-Slim models"
HOMEPAGE = "http://software-dl.ti.com/processor-sdk-linux/esd/docs/latest/linux/Foundational_Components.html#tidl"
LICENSE = "TI-TFL"

require ./tidl-utils.inc

LIC_FILES_CHKSUM = "file://docs/LICENSE.txt;md5=a93aa5af7a3bbbb6fb34c8df59efaa5c"

RDEPENDS:${PN}:class-target += "tidl-api tidl-examples"

S = "${WORKDIR}/git"

TARGET:class-target = "arm"
TARGET:class-native = "x86"
TARGET:class-nativesdk = "x86"

CP_ARGS = "-Prf --preserve=mode,timestamps --no-preserve=ownership"

do_install() {
  install -d ${D}${bindir}
  install -d ${D}${datadir}/ti/tidl/utils/test
  install -d ${D}${datadir}/ti/tidl/utils/docs
  install -m 755 ${S}/${TARGET}/bin/* ${D}${bindir}
  cp ${CP_ARGS} ${S}/test/* ${D}${datadir}/ti/tidl/utils/test/.
  cp ${CP_ARGS} ${S}/docs/* ${D}${datadir}/ti/tidl/utils/docs/.
}

FILES:${PN} += "${datadir}/ti/tidl/utils \
                ${bindir}"

BBCLASSEXTEND = "native nativesdk"

INSANE_SKIP:${PN} += "build-deps ldflags already-stripped"
