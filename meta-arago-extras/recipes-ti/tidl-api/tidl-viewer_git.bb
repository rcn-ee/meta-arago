SUMMARY = "TIDL Network Viewer"
DESCRIPTION = "TIDL Network viewer using dot and graphviz"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/tidl-api/intro.html"
LICENSE = "BSD"

include tidl-api.inc

PR = "${INC_PR}.0"

DEPENDS = "boost boost-native ti-cgt6x-native clocl-native"

S = "${WORKDIR}/git"

TARGET_class-target = "arm"
TARGET_class-native = "x86"
TARGET_class-nativesdk = "x86"

EXTRA_OEMAKE = " -C ${S}/viewer \
                 TARGET=${TARGET} \
                 TARGET_ROOTDIR=${STAGING_DIR_HOST} \
"

do_compile() {
  oe_runmake
}

do_install() {
  install -d ${D}${bindir}
  install -m 755 ${S}/viewer/${TARGET}/tidl_viewer ${D}${bindir}
}

BBCLASSEXTEND = "native nativesdk"
