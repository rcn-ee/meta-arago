SUMMARY = "C++ library for kernel mode setting"
HOMEPAGE = "https://github.com/tomba/kmsxx"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

PV = "2.1"
PR = "r1"

BRANCH = "master"
SRC_URI = "git://github.com/tomba/kmsxx.git;protocol=https;branch=${BRANCH}"
SRCREV = "5afc8d918f2c084acd65027604868dfde43395cf"

DEPENDS = "drm fmt"

# New meson build system fails to find pybind11 in sysroot, disable for now
#DEPENDS += "python3-pybind11"
#EXTRA_OEMESON = "-Dsystem-pybind11=enabled"

PACKAGES =+ "${PN}-python"

RDEPENDS:${PN}-python += "python3-core"

FILES:${PN}-python += "${libdir}/python*/site-packages"

S = "${WORKDIR}/git"

inherit python3native meson pkgconfig update-alternatives

ALTERNATIVE_PRIORITY = "100"
ALTERNATIVE:${PN} = "kmstest"
ALTERNATIVE_LINK_NAME[kmstest] = "${bindir}/kmstest"
