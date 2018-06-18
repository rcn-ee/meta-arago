PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-client.git;branch=${BRANCH} \
           file://tee-supplicant.service"

LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=69663ab153298557a59c67a60a743e5b"

PV = "3.0.0+git${SRCPV}"

BRANCH = "ti_optee_client"
SRCREV = "09b69afa5e9e74aac39e383d74f14b4d61c90476"
