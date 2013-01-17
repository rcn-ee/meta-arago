LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "df5b70b2f7cd97148855fe4d0508789c710bcc4e"
BRANCH = "master"
INC_PR = "r6"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
