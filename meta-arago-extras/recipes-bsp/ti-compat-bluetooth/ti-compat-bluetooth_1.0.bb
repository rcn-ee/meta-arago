DESCRIPTION = "TI compat-bluetooth drivers"
HOMEPAGE = "https://gforge.ti.com/gf/project/ecs_nlcp/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit module

RDEPENDS_${PN} = "ti-compat-wireless-wl12xx"

PR = "${MACHINE_KERNEL_PR}"
PR_append = "a"

COMPAT_BLUETOOTH_VERSION = "2012-05-22-r5-18"
TAG = "${@'${COMPAT_BLUETOOTH_VERSION}'.replace('-', '')}"
PV = "0.${TAG}"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/865/5622/compat-bluetooth-wl12xx-2012-05-22-r5-18.tgz \
           file://0001-compat-bluetooth-2.6-removed-unused-BT-modules-from-.patch \
           file://0002-Bluetooth-Fix-l2cap-conn-failures-for-ssp-devices.patch \
           file://0001-compat-bluetooth-fixing-kernel-panic-in-l2cap.patch \
          "

SRC_URI[md5sum] = "85118756a605ebd8f4fbff19995368a6"
SRC_URI[sha256sum] = "d250a6447de54f0776a12ca604bf2a2a48b022108b699de5008f48462e535393"

S = "${WORKDIR}/compat-bluetooth/"

EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB=${D}"

do_configure() {
    cd ${S}
    ./scripts/driver-select bt
}

do_install() {
    oe_runmake DEPMOD=echo DESTDIR="${D}" INSTALL_MOD_PATH="${D}" LDFLAGS="" install-modules
    find ${D} -name compat.ko | xargs rm
}
