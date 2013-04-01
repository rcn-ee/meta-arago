DESCRIPTION = "TI compat-bluetooth drivers"
HOMEPAGE = "https://gforge.ti.com/gf/project/ecs_nlcp/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit module

RDEPENDS_${PN} = "ti-compat-wireless-wl12xx"

PR = "${MACHINE_KERNEL_PR}b"

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

