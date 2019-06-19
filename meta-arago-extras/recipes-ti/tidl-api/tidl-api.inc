PV = "1.3.0"
INC_PR = "r1"

LIC_FILES_CHKSUM = "file://license.txt;md5=e3daeabffb9fc131a73f16d16cbdb118"

GIT_URI = "git://git.ti.com/tidl/tidl-api.git"
GIT_PROTOCOL = "git"
BRANCH = "master"

SRC_URI = "${GIT_URI};protocol=${GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "785170685ca6a5c11876b05ddf74741c419393be"

# default patchdir is ${S}
SRC_URI += "file://0001-tidl-api_l2_cache_size.patch"
S = "${WORKDIR}/git"
