SUMMARY = "Wayland IVI Extension"
DESCRIPTION = "GENIVI Layer Management API based on Wayland IVI Extension"
HOMEPAGE = "http://projects.genivi.org/wayland-ivi-extension"
BUGTRACKER = "http://bugs.genivi.org/enter_bug.cgi?product=Wayland%20IVI%20Extension"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1f1a56bb2dadf5f2be8eb342acf4ed79"

SRCREV = "d2c2e262f3bdc9db33b3014293fcdbcfdc90ab27"

SRC_URI = "git://github.com/GENIVI/${BPN}.git;protocol=http \
           file://force-type-conversion.patch \
    "

S = "${WORKDIR}/git"

DEPENDS = "weston virtual/libgles2 pixman wayland-native"

inherit cmake

EXTRA_OECMAKE := "-DWITH_ILM_INPUT=1"

FILES_${PN} += "${libdir}/weston/*"
FILES_${PN}-dbg += "${libdir}/weston/.debug/*"

EXTRA_OECMAKE += "-DLIB_SUFFIX=${@d.getVar('baselib', True).replace('lib', '')}"

PR = "r1"

# Need these temporarily to prevent a non-fatal do_package_qa issue
INSANE_SKIP_${PN} += "dev-deps"
INSANE_SKIP_${PN}-dev += "dev-elf dev-so"
