SUMMARY = "TI OpenMP Accelerator Model"
HOMEPAGE = "http://downloads.ti.com/mctools/esd/docs/openmpacc/"
LICENSE = "BSD"

PV = "1.5.0.0"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://../debian/copyright;md5=aaa2a0939d08197132fc382e97b62eb0"

FILESEXTRAPATHS_prepend := "${THISDIR}/openmpacc:"

OMPACC_GIT_URI = "git://git.ti.com/openmp/ti-openmpacc.git"
OMPACC_GIT_PROTOCOL = "git"
OMPACC_GIT_BRANCH = "master"

OMPACC_SRCREV = "f0aca40a7644d8934453403f8cad63cb2e4944d8"

BRANCH = "${OMPACC_GIT_BRANCH}"
SRC_URI = "${OMPACC_GIT_URI};protocol=${OMPACC_GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "${OMPACC_SRCREV}"

