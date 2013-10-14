LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "dfd328c9e34aa3c01f39d76f8ae584d8bc8aacc1"
BRANCH = "master"
INC_PR = "r17"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
