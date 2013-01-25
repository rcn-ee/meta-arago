# This is a TI specific version of the compat-wireless recipe using a
# compat-wireless package created from the TI Systems Tested mac80211 releases.

DESCRIPTION = "ti compat-wireless drivers"
HOMEPAGE = "https://gforge.ti.com/gf/project/ecs_nlcp/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=d7810fab7487fb0aad327b76f1be7cd7"

RDEPENDS_${PN} = "wireless-tools"

TAG = "${@'${COMPAT_WIRELESS_VERSION}'.replace('-', '')}"
PV = "0.${TAG}"

inherit module

PR = "${MACHINE_KERNEL_PR}"
PR_append = "a"

COMPAT_WIRELESS_VERSION = "2012-11-18-r5-sp3"

S = "${WORKDIR}/compat-wireless"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/994/6330/ti-compat-wireless-R5_SP3.05.tar.gz \
           file://0001-compat-wireless-add-pm_runtime_enabled.patch \
           file://0001-compat-wireless-exclude-BT-building.patch \
           file://0002-compat-wireless-enable-test-mode.patch \
           file://0004-added-driver-version.patch \
           file://0002-ti-compat-wireless-enable-uapsd-configuration.patch \
           file://0001-wl12xx-additional-two-members-for-wl12xx_platform_da.patch \
           file://0001-git-version-use-compat-base-tree.patch \
          "
SRC_URI_append_am335x-evm = "file://0001-wl12xx-Decrease-number-of-RX-transactions.patch \
                             file://0002-wl12xx-Decrease-number-of-TX-transactions.patch \
"

SRC_URI[md5sum] = "3d86e0cbd0e2f07d09bf3cd52b6b2f98"
SRC_URI[sha256sum] = "927e4a6f8397973c7ed30dada28a661b76486004756beef38176fda35370dd83"

EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB=${D}"

do_configure() {
    cd ${S}
    ./scripts/driver-select wl12xx
}

do_configure_append() {
    sed -i "s#@./scripts/update-initramfs## " Makefile
}

do_install() {
    oe_runmake DEPMOD=echo DESTDIR="${D}" INSTALL_MOD_PATH="${D}" LDFLAGS="" install-modules
}
