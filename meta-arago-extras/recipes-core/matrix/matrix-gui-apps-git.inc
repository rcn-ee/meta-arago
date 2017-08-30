LICENSE = "CC-BY-SA-3.0"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://git.ti.com/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "50a2f2ec7043e17bc7af72186e3d0a8d7773ec0a"
BRANCH = "master"
INC_PR = "r48"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
