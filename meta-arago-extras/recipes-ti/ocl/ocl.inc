PV = "1.1.6"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://../debian/copyright;md5=2e3965a73a8a49c23836467266120dff"

FILESEXTRAPATHS_prepend := "${THISDIR}/ocl:"

BRANCH = "master"
SRC_URI = "git://git.ti.com/opencl/ti-opencl.git;protocol=git;branch=${BRANCH}"
SRCREV = "992dfba8783af895f6d4e4877ad7c0466d085bf0"
