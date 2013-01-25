DESCRIPTION = "TI compat-bluetooth drivers"
HOMEPAGE = "https://gforge.ti.com/gf/project/ecs_nlcp/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit module

RDEPENDS_${PN} = "ti-compat-wireless-wl12xx"

PR = "${MACHINE_KERNEL_PR}"
PR_append = "b"

COMPAT_BLUETOOTH_VERSION = "2012-11-19-r5-sp3"
TAG = "${@'${COMPAT_BLUETOOTH_VERSION}'.replace('-', '')}"
PV = "0.${TAG}"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/802/5435/ti-compat-bluetooth-2012-02-20.tar.gz \
           file://0001-compat-bluetooth-2.6-removed-unused-BT-modules-from-.patch \
           file://0002-Bluetooth-Fix-l2cap-conn-failures-for-ssp-devices.patch \
           file://0001-compat-bluetooth-fixing-kernel-panic-in-l2cap.patch \
          "

SRC_URI[md5sum] = "7c231b35a2297391b5192f86ff4f10dd"
SRC_URI[sha256sum] = "d8882da8bb37821bfd0b9334b859f64d0ce82ae5262360367a3f3fdf31c7f350"

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
