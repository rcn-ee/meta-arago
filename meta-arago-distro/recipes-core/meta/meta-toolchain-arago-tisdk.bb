require recipes-core/meta/meta-toolchain-arago-qte.bb

TOOLCHAIN_TARGET_TASK = "task-arago-toolchain-tisdk-target"
TOOLCHAIN_OUTPUTNAME = "${SDK_NAME}-${ARMPKGARCH}-${TARGET_OS}-tisdk-${SDK_ARCH}"

PR = "r0"

toolchain_create_sdk_env_script_append() {
    echo -e 'export PS1="\[\\e[32;1m\][linux-devkit]\[\\e[0m\]:\w> "' >> $script
}
