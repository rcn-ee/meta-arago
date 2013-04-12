LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "2f938391c53826d261f41e8a177413793194499e"
BRANCH = "master"
INC_PR = "r12"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
