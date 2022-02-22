require tisdk-core-bundle.inc

DEPLOY_SPL_NAME:omapl138 = ""
DEPLOY_SPL_NAME:k3 = "tispl.bin tiboot3.bin"

DEPLOY_IMAGES_NAME:k3 = "bl31.bin bl32.bin"
DEPLOY_IMAGES_NAME:append:am65xx = " sysfw.itb"
DEPLOY_IMAGES_NAME:append:j7-evm = " sysfw.itb"
DEPLOY_IMAGES_NAME:append:j7-hs-evm = " sysfw.itb"
DEPLOY_IMAGES_NAME:append:am65xx-evm = " ti-sci-firmware-am65x-gp.bin sysfw-am65x-evm.itb sysfw-am65x_sr2-evm.itb"
DEPLOY_IMAGES_NAME:append:j7-evm = " ti-fs-firmware-j721e-gp.bin"

ARAGO_TISDK_IMAGE ?= "tisdk-core-bundle"
export IMAGE_BASENAME = "${ARAGO_TISDK_IMAGE}"
