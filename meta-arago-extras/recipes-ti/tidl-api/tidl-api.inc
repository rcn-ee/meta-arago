PV = "1.5.1"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://license.txt;md5=e3daeabffb9fc131a73f16d16cbdb118"

GIT_URI = "git://git.ti.com/tidl/tidl-api.git"
GIT_PROTOCOL = "git"
BRANCH = "master"

SRC_URI = "${GIT_URI};protocol=${GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "4b801ad96b50f53e977b96d8b227ba4bcb26e011"

# default patchdir is ${S}
S = "${WORKDIR}/git"

inherit features_check

REQUIRED_MACHINE_FEATURES = "dsp"
REQUIRED_MACHINE_FEATURES:class-native = ""
REQUIRED_MACHINE_FEATURES:class-nativesdk = ""
REQUIRED_DISTRO_FEATURES = "opencl opencv"
