LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "6a76c32dd0764825c4f4c8259d09299e8a15ea5e"
BRANCH = "master"
INC_PR = "r11"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
