PV = "1.1.4"
INC_PR = "r0"

LIC_FILES_CHKSUM = "file://../debian/copyright;md5=2e3965a73a8a49c23836467266120dff"

FILESEXTRAPATHS_prepend := "${THISDIR}/ocl:"

BRANCH = "master"
SRC_URI = "git://git.ti.com/opencl/ti-opencl.git;protocol=git;branch=${BRANCH}"
SRCREV = "a675f28647b294d0fc5d5234dd8bcf89a330a0e5"
