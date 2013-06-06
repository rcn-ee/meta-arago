TOOLCHAIN_TARGET_TASK ?= "packagegroup-arago-toolchain-tisdk-target"
TOOLCHAIN_SUFFIX ?= "-tisdk"
TOOLCHAIN_CLEANUP_PACKAGES ?= "libgnutls-dev libgnutls-extra26 libgnutls-openssl27 libtasn1-dev"

require recipes-core/meta/meta-toolchain-arago-qte.bb

PR = "r3"

toolchain_create_sdk_env_script_append() {
    echo -e 'export PS1="\[\\e[32;1m\][linux-devkit]\[\\e[0m\]:\w> "' >> $script
}
