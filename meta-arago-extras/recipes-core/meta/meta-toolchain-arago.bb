TOOLCHAIN_HOST_TASK ?= "task-arago-sdk-host-nativesdk task-arago-cross-canadian-${TRANSLATED_TARGET_ARCH}"
TOOLCHAIN_TARGET_TASK ?= "task-core-standalone-sdk-target task-core-standalone-sdk-target-dbg"
TOOLCHAIN_OUTPUTNAME ?= "${SDK_NAME}-sdk-${DISTRO}-${DISTRO_VERSION}"

require recipes-core/meta/meta-toolchain.bb

#TOOLCHAIN_NEED_CONFIGSITE_CACHE += "zlib"
