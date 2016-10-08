SUMMARY = "TI OpenMP Accelerator Model"
HOMEPAGE = "http://downloads.ti.com/mctools/esd/docs/openmpacc/"
LICENSE = "BSD"

PV = "1.4.0.2"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://../debian/copyright;md5=aaa2a0939d08197132fc382e97b62eb0"

FILESEXTRAPATHS_prepend := "${THISDIR}/openmpacc:"

OMPACC_GIT_URI = "git://git.ti.com/openmp/ti-openmpacc.git"
OMPACC_GIT_PROTOCOL = "git"
OMPACC_GIT_BRANCH = "master"

OMPACC_SRCREV = "b5b83713898fc45b169017975219b5ef5fe5932d"

BRANCH = "${OMPACC_GIT_BRANCH}"
SRC_URI = "${OMPACC_GIT_URI};protocol=${OMPACC_GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "${OMPACC_SRCREV}"

