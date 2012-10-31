TOOLCHAIN_HOST_TASK ?= "task-arago-sdk-host-nativesdk task-arago-cross-canadian-${TRANSLATED_TARGET_ARCH}"
TOOLCHAIN_TARGET_TASK ?= "task-core-standalone-sdk-target"
TOOLCHAIN_OUTPUTNAME ?= "${SDK_NAME}-${ARMPKGARCH}-${TARGET_OS}-sdk-${SDK_ARCH}"

require recipes-core/meta/meta-toolchain.bb

PR = "r1"

SDKTARGETSYSROOT = "${SDKPATH}/${ARAGO_TARGET_SYS}"

toolchain_create_sdk_env_script_append () {
	sed 's|export PATH=.*$|export PATH=${SDKPATHNATIVE}${base_bindir}:${SDKPATHNATIVE}${bindir}:$PATH|' -i $script
}
