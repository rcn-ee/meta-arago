LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "27e8eb76f4a405c123a9f816b1b389e20b06f30c"
BRANCH = "master"
INC_PR = "r0"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
