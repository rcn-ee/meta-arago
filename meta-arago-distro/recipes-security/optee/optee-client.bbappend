PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-client.git;branch=${BRANCH} \
           file://tee-supplicant.service"

LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=69663ab153298557a59c67a60a743e5b"

PV = "2.5.0+git${SRCPV}"

BRANCH = "ti_optee_client"
SRCREV = "0efaf6bae1066d06a075d1f4fe1011b8b3576f75"
