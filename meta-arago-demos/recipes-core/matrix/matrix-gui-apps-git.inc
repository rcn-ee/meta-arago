LICENSE = "CC-BY-SA-3.0"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://git.ti.com/git/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=https;branch=${BRANCH}"
SRCREV = "011bc0ab43110eb2fca4dd6c58fc0433642da8d6"
BRANCH = "master"
INC_PR = "r77"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc

INSANE_SKIP:${PN} += "installed-vs-shipped"
