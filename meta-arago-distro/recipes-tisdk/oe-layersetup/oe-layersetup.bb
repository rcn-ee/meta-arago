DESCRIPTION = "Package that contains a script to setup oe-core development environment"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r1"

inherit allarch

BRANCH ?= "master"
SRCREV = "e58f941784fb45fd826779a45b33973e6342700f"
SRC_URI = "git://arago-project.org/git/projects/oe-layersetup.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/"
