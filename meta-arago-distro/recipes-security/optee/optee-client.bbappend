PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-client.git;branch=${BRANCH} \
           file://tee-supplicant.service"

LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=69663ab153298557a59c67a60a743e5b"

PV = "2.6.0+git${SRCPV}"

BRANCH = "ti_optee_client"
SRCREV = "73b4e490a8ed0b4a7714818e80998b9d8a7da958"
