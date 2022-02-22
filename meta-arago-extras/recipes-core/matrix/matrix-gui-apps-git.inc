LICENSE = "CC-BY-SA-3.0"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://git.ti.com/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "976e775a1275198d3391018ce8115a66d00120a2"
BRANCH = "master"
INC_PR = "r76"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc

INSANE_SKIP:${PN} += "installed-vs-shipped"
