SUMMARY = "Wayland IVI Extension"
DESCRIPTION = "GENIVI Layer Management API based on Wayland IVI Extension"
HOMEPAGE = "http://projects.genivi.org/wayland-ivi-extension"
BUGTRACKER = "http://bugs.genivi.org/enter_bug.cgi?product=Wayland%20IVI%20Extension"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1f1a56bb2dadf5f2be8eb342acf4ed79"

SRCREV = "10584b4d55c231a11964db0191c3707459982d4b"

SRC_URI = "git://github.com/GENIVI/${BPN}.git;protocol=http \
           file://0001-force-type-conversion.patch \
    "

S = "${WORKDIR}/git"

DEPENDS = "weston virtual/libgles2 pixman wayland-native"

inherit cmake

EXTRA_OECMAKE := "-DWITH_ILM_INPUT=1"

FILES_${PN} += "${datadir}/wayland-protocols/stable/ivi-application/ivi-application.xml"
FILES_${PN} += "${libdir}/weston/*"
FILES_${PN}-dbg += "${libdir}/weston/.debug/*"

EXTRA_OECMAKE += "-DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')}"

PR = "r0"

# Need these temporarily to prevent a non-fatal do_package_qa issue
INSANE_SKIP_${PN} += "dev-deps"
INSANE_SKIP_${PN}-dev += "dev-elf dev-so"
