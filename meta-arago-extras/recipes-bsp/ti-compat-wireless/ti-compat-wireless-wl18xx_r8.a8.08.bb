# This is a TI specific version of the compat-wireless recipe using a
# compat-wireless package created from the TI Systems Tested mac80211 releases.

DESCRIPTION = "ti compat-wireless drivers for wl18xx"
HOMEPAGE = "https://gforge.ti.com/gf/project/ecs_nlcp/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

RDEPENDS_${PN} = "wireless-tools"

PROVIDES += "ti-compat-wireless-wl12xx"
RPROVIDES_${PN} += "ti-compat-wireless-wl12xx"
RREPLACES_${PN} += "ti-compat-wireless-wl12xx"
RCONFLICTS_${PN} += "ti-compat-wireless-wl12xx"

COMPATIBLE_MACHINE = "(omap-a15)"

PV = "r8.a8.08"
inherit module

PR = "${MACHINE_KERNEL_PR}"
PR_append = "a"

# Tags: ol_r8.a8.08
SRCREV_wl18xx = "eaa1820c02dc076e6ad9254e9cb7a3bb0c17471b"
SRCREV_compat = "5d80865281795f962e1400a95202bbd07dd763c0"
SRCREV_compat-wireless = "23a0d62ea1a57327709a77f08d6265ec807a909f"

SRCREV_FORMAT = "compat-wireless"

S = "${WORKDIR}/compat-wireless"

SRC_URI = "git://github.com/TI-OpenLink/compat-wireless.git;destsuffix=compat-wireless;name=compat-wireless \
           git://github.com/TI-OpenLink/compat.git;destsuffix=compat;name=compat \
           git://github.com/TI-OpenLink/wl18xx.git;destsuffix=wl18xx;name=wl18xx \
"

EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB=${D}"

do_configure() {
    cd ${S}
    GIT_TREE="${WORKDIR}/wl18xx" GIT_COMPAT_TREE="${WORKDIR}/compat" ./scripts/admin-refresh.sh network
    ./scripts/driver-select wl18xx

    # Now generate the sourceipk with the properly configured sources
    sourceipk_do_create_srcipk
}

do_configure_append() {
    sed -i "s#@./scripts/update-initramfs## " Makefile
}

do_install() {
    # Remove hardcoded references to host depmod
    sed -i "s#@/sbin/depmod -a## " Makefile
    sed -i "s#@/sbin/depmod -ae## " Makefile

    # Install modules
    oe_runmake DEPMOD=echo DESTDIR="${D}" INSTALL_MOD_PATH="${D}" LDFLAGS="" install-modules
}
