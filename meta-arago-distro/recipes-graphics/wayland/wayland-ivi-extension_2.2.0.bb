SUMMARY = "Wayland IVI Extension"
DESCRIPTION = "GENIVI Layer Management API based on Wayland IVI Extension"
HOMEPAGE = "http://projects.genivi.org/wayland-ivi-extension"
BUGTRACKER = "http://bugs.genivi.org/enter_bug.cgi?product=Wayland%20IVI%20Extension"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1f1a56bb2dadf5f2be8eb342acf4ed79"

SRCREV = "e9c2fe4c5034a06b159cfd45dbd485755cbaf4c8"

SRC_URI = "git://github.com/GENIVI/${BPN}.git;protocol=http \
           file://01-ivi-input-controller-update-to-weston-7.patch \
           file://02-ivi-id-agent-update-to-weston-7-header.patch \
           file://03-ivi-id-agent-update-dependencies-to-build-on-weston-8.patch \
    "

S = "${WORKDIR}/git"

DEPENDS = "weston virtual/libgles2 pixman wayland-native"

inherit cmake

EXTRA_OECMAKE := "-DWITH_ILM_INPUT=1"

FILES_${PN} += "${datadir}/wayland-protocols/stable/ivi-application/ivi-application.xml"
FILES_${PN} += "${libdir}/weston/*"
FILES_${PN}-dbg += "${libdir}/weston/.debug/*"

EXTRA_OECMAKE += "-DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')}"

PR = "r1"

# Need these temporarily to prevent a non-fatal do_package_qa issue
INSANE_SKIP_${PN} += "dev-deps"
INSANE_SKIP_${PN}-dev += "dev-elf dev-so"
