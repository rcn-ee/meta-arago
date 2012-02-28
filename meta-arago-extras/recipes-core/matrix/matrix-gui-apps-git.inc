LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "de6618b7ee3d6b0957bad2c8b8310a5869ad169e"
BRANCH = "master"
INC_PR = "r1"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
