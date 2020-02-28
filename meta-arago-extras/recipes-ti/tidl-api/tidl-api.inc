PV = "1.5.0"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://license.txt;md5=e3daeabffb9fc131a73f16d16cbdb118"

GIT_URI = "git://git.ti.com/tidl/tidl-api.git"
GIT_PROTOCOL = "git"
BRANCH = "master"

SRC_URI = "${GIT_URI};protocol=${GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "eeb4c457c8881a81fbf59a60b2ee070d2450a935"

# default patchdir is ${S}
S = "${WORKDIR}/git"
