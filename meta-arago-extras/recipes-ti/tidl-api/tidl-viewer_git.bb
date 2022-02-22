SUMMARY = "TIDL Network Viewer"
DESCRIPTION = "TIDL Network viewer using dot and graphviz"
HOMEPAGE = "https://downloads.ti.com/mctools/esd/docs/tidl-api/intro.html"
LICENSE = "BSD"

include tidl-api.inc

PR = "${INC_PR}.0"

DEPENDS = "boost boost-native ti-cgt6x-native clocl-native"

TARGET:class-target = "arm"
TARGET:class-native = "x86"
TARGET:class-nativesdk = "x86"

CXXFLAGS:append:class-native    = " -DPLATFORM_64BIT "
CXXFLAGS:append:class-nativesdk = " -DPLATFORM_64BIT "

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
