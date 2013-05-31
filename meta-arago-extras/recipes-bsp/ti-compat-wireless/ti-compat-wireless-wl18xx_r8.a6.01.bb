# This is a TI specific version of the compat-wireless recipe using a
# compat-wireless package created from the TI Systems Tested mac80211 releases.

DESCRIPTION = "ti compat-wireless drivers for wl18xx"
HOMEPAGE = "https://gforge.ti.com/gf/project/ecs_nlcp/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=d7810fab7487fb0aad327b76f1be7cd7"

RDEPENDS_${PN} = "wireless-tools"

PROVIDES += "ti-compat-wireless-wl12xx"
RPROVIDES_${PN} += "ti-compat-wireless-wl12xx"
RREPLACES_${PN} += "ti-compat-wireless-wl12xx"
RCONFLICTS_${PN} += "ti-compat-wireless-wl12xx"

PV = "r8.a6.01"
inherit module

PR = "${MACHINE_KERNEL_PR}"
PR_append = "b"

# Tags: ol_r8.a6.01
SRCREV_wl18xx = "1c0f45f0e8aec0823175f7ac977908888c424aa1"
SRCREV_compat = "c37c46c4ab5085ba50f650d15854404983b8d09b"
SRCREV_compat-wireless = "3ec9ecca2cb07584e115ba53117f0084fc8faa25"

SRCREV_FORMAT = "compat-wireless"

S = "${WORKDIR}/compat-wireless"

SRC_URI = "git://github.com/TI-OpenLink/compat-wireless.git;destsuffix=compat-wireless;name=compat-wireless \
           git://github.com/TI-OpenLink/compat.git;destsuffix=compat;name=compat \
           git://github.com/TI-OpenLink/wl18xx.git;destsuffix=wl18xx;name=wl18xx \
           file://0001-git-version-wl18xx-use-compat-base-tree.patch;patchdir=../wl18xx \
           file://0001-wl12xx-additional-two-members-for-wl12xx_platform_da.patch;patchdir=../wl18xx \
          "


EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB=${D}"

# Prevent sourceipk clear_git function from running.
# This preserves the git repo until driver-select is ran.

clear_git() {
    :
}

do_configure() {
    cd ${S}
    GIT_TREE="${WORKDIR}/wl18xx" GIT_COMPAT_TREE="${WORKDIR}/compat" ./scripts/admin-refresh.sh
    ./scripts/driver-select wl18xx

    # Delete the .git repository since it should no longer be needed.
    rm -rf ${S}/.git ${S}/.gitignore

    # Now generate the sourceipk with the properly configured sources
    sourceipk_do_create_srcipk
}

do_configure_append() {
    sed -i "s#@./scripts/update-initramfs## " Makefile
}

do_install() {
    oe_runmake DEPMOD=echo DESTDIR="${D}" INSTALL_MOD_PATH="${D}" LDFLAGS="" install-modules
}
