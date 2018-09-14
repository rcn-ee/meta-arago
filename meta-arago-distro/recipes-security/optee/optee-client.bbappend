PR_append = ".arago1"

SRC_URI = "git://git.ti.com/optee/ti-optee-client.git;branch=${BRANCH} \
           file://tee-supplicant.service"

LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=69663ab153298557a59c67a60a743e5b"

PV = "3.2.0+git${SRCPV}"

BRANCH = "ti_optee_client"
SRCREV = "6b4ca04b3a3738f7697597164dc1e055d4e65441"
