PV = "1.4.0"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://license.txt;md5=e3daeabffb9fc131a73f16d16cbdb118"

GIT_URI = "git://git.ti.com/tidl/tidl-api.git"
GIT_PROTOCOL = "git"
BRANCH = "master"

SRC_URI = "${GIT_URI};protocol=${GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "21faf4b36a0ae9ee5b5c6aaf90d067728ff4f78b"

# default patchdir is ${S}
S = "${WORKDIR}/git"
