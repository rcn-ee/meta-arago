require arago-core-tisdk-image.inc

DEPLOY_SPL_NAME_omapl138 = ""
DEPLOY_SPL_NAME_k2hk = ""
DEPLOY_SPL_NAME_k2l = ""
DEPLOY_SPL_NAME_k2e = ""
# Only unset it for HS device, as k2g GP does provide MLO/SPL
DEPLOY_SPL_NAME_k2g-hs-evm = ""
DEPLOY_SPL_NAME_k3 = "tispl.bin tiboot3.bin"

DEPLOY_IMAGES_NAME_k3 = "bl31.bin bl32.bin sysfw.bin"

ARAGO_TISDK_IMAGE ?= "arago-core-tisdk-image"
export IMAGE_BASENAME = "${ARAGO_TISDK_IMAGE}"
