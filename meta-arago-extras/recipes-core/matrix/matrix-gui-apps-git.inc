LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "49cd9138b00749acf82a8ac8ab78c8ae9d364bc5"
BRANCH = "master"
INC_PR = "r19"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
