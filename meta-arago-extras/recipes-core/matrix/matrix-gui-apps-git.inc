LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "cf78c056a48573600438535adb31b4415377bc00"
BRANCH = "master"
INC_PR = "r3"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
