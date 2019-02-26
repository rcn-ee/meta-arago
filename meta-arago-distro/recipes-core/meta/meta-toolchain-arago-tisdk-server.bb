TOOLCHAIN_HOST_TASK ?= "nativesdk-packagegroup-arago-tisdk-host"
TOOLCHAIN_SUFFIX ?= "-tisdk-server"

require meta-toolchain-arago-tisdk.inc
require recipes-core/meta/meta-toolchain-arago.bb

PR = "${INC_PR}.0"
