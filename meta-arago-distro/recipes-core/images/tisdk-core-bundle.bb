SUMMARY = "Installer package for TI SDK - NOT for direct use on target"

DESCRIPTION = "This creates an installer including all the default images\
 recommended including source, binaries, filesystems, etc.\
 for TI SDK. This is meant to be used on the host system.\
"

require tisdk-core-bundle.inc

DEPLOY_SPL_NAME:omapl138 = ""
DEPLOY_SPL_NAME:k3 = "tispl.bin tiboot3.bin"

DEPLOY_IMAGES_NAME:k3 = "bl31.bin bl32.bin"
DEPLOY_IMAGES_NAME:append:am65xx = " sysfw.itb"
DEPLOY_IMAGES_NAME:append:j721e-evm = " sysfw.itb"
DEPLOY_IMAGES_NAME:append:j721e-hs-evm = " sysfw.itb"
DEPLOY_IMAGES_NAME:append:am65xx-evm = " ti-sci-firmware-am65x-gp.bin sysfw-am65x-evm.itb sysfw-am65x_sr2-evm.itb"
DEPLOY_IMAGES_NAME:append:j721e-evm = " ti-fs-firmware-j721e-gp.bin"

ARAGO_TISDK_IMAGE ?= "tisdk-core-bundle"
export IMAGE_BASENAME = "${ARAGO_TISDK_IMAGE}"
