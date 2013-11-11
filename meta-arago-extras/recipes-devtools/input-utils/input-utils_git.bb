DESCRIPTION = "Utilities for the Linux input drivers"
HOMEPAGE = "http://packages.tanglu.org/source/aequorea/input-utils"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

PV = "1.0"
PR = "r0"

BRANCH ?= "master"
SRCREV = "230a22bda95ea5616251b43db418f9df445651b6"

SRC_URI = "git://git.debian.org/collab-maint/input-utils.git;protocol=git;branch=${BRANCH}"
SRC_URI_append_arm = " file://0001-autoconf-fix-for-cross-compilation-for-ARM.patch"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake
}

# set the DESTDIR and the STRIP variables used by the GNUmakefile.
# The STRIP variable is set to blank or else the variable setting from OE
# is picked up as <TC>-strip and the install step sees that as another
# file to install.
EXTRA_OEMAKE = "DESTDIR=${D} STRIP=''"

do_install () {
    oe_runmake install
}
