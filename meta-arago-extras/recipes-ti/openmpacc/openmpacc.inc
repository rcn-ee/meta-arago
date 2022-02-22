SUMMARY = "TI OpenMP Accelerator Model"
HOMEPAGE = "http://downloads.ti.com/mctools/esd/docs/openmpacc/"
LICENSE = "BSD-3-Clause"

inherit features_check

REQUIRED_MACHINE_FEATURES = "dsp"
REQUIRED_MACHINE_FEATURES:class-native = ""
REQUIRED_MACHINE_FEATURES:class-nativesdk = ""
REQUIRED_DISTRO_FEATURES = "opencl openmp"

PV = "1.5.6.0"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://../debian/copyright;md5=aaa2a0939d08197132fc382e97b62eb0"

FILESEXTRAPATHS:prepend := "${THISDIR}/openmpacc:"

OMPACC_GIT_URI = "git://git.ti.com/openmp/ti-openmpacc.git"
OMPACC_GIT_PROTOCOL = "git"
OMPACC_GIT_BRANCH = "master"

OMPACC_SRCREV = "7c4e68a0bf73ec193edff9dfc23ea764ae6ad434"

BRANCH = "${OMPACC_GIT_BRANCH}"
SRC_URI = "${OMPACC_GIT_URI};protocol=${OMPACC_GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "${OMPACC_SRCREV}"
