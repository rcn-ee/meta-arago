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

COMPAT_WIRELESS_VERSION = "2012-05-15-r5-18"

S = "${WORKDIR}/compat-wireless"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/864/5621/ti-compat-wireless-wl12xx-2012-05-17-r5-18.tar.gz \
           file://0001-compat-wireless-add-pm_runtime_enabled.patch \
           file://0001-compat-wireless-exclude-BT-building.patch \
           file://0002-compat-wireless-enable-test-mode.patch \
           file://0004-added-driver-version.patch \
           file://0002-ti-compat-wireless-enable-uapsd-configuration.patch \
           file://0001-wl12xx-detect-between-wl1271-PG-3.0-and-lower.patch \
           file://0001-wl12xx-additional-two-members-for-wl12xx_platform_da.patch \
          "
SRC_URI_append_am335x-evm = "file://0001-wl12xx-Decrease-number-of-RX-transactions.patch \
                             file://0002-wl12xx-Decrease-number-of-TX-transactions.patch \
"

SRC_URI[md5sum] = "9b6228d2ad39ece76ec022452df59621"
SRC_URI[sha256sum] = "c5564cbdb5d89d488be13f8d9310242597728eb1e0918ef64a6fae55dba53f5e"

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
