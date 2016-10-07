SUMMARY = "C++ library for kernel mode setting"
HOMEPAGE = "https://github.com/tomba/kmsxx"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c670e18272184fc0e86e1648678b4f2a"

PV = "1.0"
PR = "r0"

BRANCH = "master"
SRC_URI = "git://github.com/tomba/kmsxx.git;protocol=git;branch=${BRANCH}"
SRCREV = "546e8d16dbc4dc74038dbcf86567186dbd80c3ab"

DEPENDS = "drm python3 python3-pybind11"

S = "${WORKDIR}/git"

inherit cmake update-alternatives

ALTERNATIVE_PRIORITY = "100"
ALTERNATIVE_${PN} = "kmstest"
ALTERNATIVE_LINK_NAME[kmstest] = "${bindir}/kmstest"
