# patch version at the end needs to be in double digits
PV = "1.1.19.01"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://../debian/copyright;md5=2e3965a73a8a49c23836467266120dff"

FILESEXTRAPATHS_prepend := "${THISDIR}/ocl:"

OCL_GIT_URI = "git://git.ti.com/opencl/ti-opencl.git"
OCL_GIT_PROTOCOL = "git"
OCL_GIT_BRANCH = "master"


OCL_SRCREV = "517b95417982e001cda8948509fcc75e0a5b2f14"

BRANCH = "${OCL_GIT_BRANCH}"
SRC_URI = "${OCL_GIT_URI};protocol=${OCL_GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "${OCL_SRCREV}"
