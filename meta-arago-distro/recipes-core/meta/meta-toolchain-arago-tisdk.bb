TOOLCHAIN_SUFFIX ?= "-tisdk"

require meta-toolchain-arago-tisdk.inc
require recipes-core/meta/meta-toolchain-arago-qte.bb

PR = "${INC_PR}.0"
