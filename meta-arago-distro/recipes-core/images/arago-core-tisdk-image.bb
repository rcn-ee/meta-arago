require arago-core-tisdk-image.inc

DEPLOY_SPL_NAME_omapl138 = ""
DEPLOY_SPL_NAME_k2hk = ""
DEPLOY_SPL_NAME_k2l-evm = ""
DEPLOY_SPL_NAME_k2e = ""
# Only unset it for HS device, as k2g GP does provide MLO/SPL
DEPLOY_SPL_NAME_k2g-hs-evm = ""

ARAGO_TISDK_IMAGE ?= "arago-core-tisdk-image"
export IMAGE_BASENAME = "${ARAGO_TISDK_IMAGE}"
