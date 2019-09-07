PV = "1.3.1"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://license.txt;md5=e3daeabffb9fc131a73f16d16cbdb118"

GIT_URI = "git://git.ti.com/tidl/tidl-api.git"
GIT_PROTOCOL = "git"
BRANCH = "master"

SRC_URI = "${GIT_URI};protocol=${GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "73efef4ab6b4c9c20f6ade372c396043e6d36b40"

# default patchdir is ${S}
S = "${WORKDIR}/git"
