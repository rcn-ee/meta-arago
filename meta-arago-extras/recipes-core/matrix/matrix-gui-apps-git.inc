LICENSE = "CC-BY-SA-3.0"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=http;branch=${BRANCH}"
SRCREV = "200426006a3ae68bde9d7eb6a864da51fe07298c"
BRANCH = "master"
INC_PR = "r30"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
