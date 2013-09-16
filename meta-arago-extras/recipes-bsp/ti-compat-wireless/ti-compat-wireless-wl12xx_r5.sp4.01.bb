# This is a TI specific version of the compat-wireless recipe using a
# compat-wireless package created from the TI Systems Tested mac80211 releases.

DESCRIPTION = "ti compat-wireless drivers"
HOMEPAGE = "https://gforge.ti.com/gf/project/ecs_nlcp/"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=d7810fab7487fb0aad327b76f1be7cd7"

RDEPENDS_${PN} = "wireless-tools"

inherit module

PR = "${MACHINE_KERNEL_PR}"
PR_append = "e"

# Tags: ol_R5.SP4.01
SRCREV_wl12xx = "e96a68476155f1c3576066ab2d0b1417835dfdcf"
SRCREV_compat = "984ab77279488f3fea4436da76c0f81a618cef1b"
SRCREV_compat-wireless = "bcc169e624f54e643e182bc6c15b6380b2f8408a"

SRCREV_FORMAT = "compat-wireless"

S = "${WORKDIR}/compat-wireless"

SRC_URI = "git://github.com/TI-OpenLink/compat-wireless.git;destsuffix=compat-wireless;name=compat-wireless \
           git://github.com/TI-OpenLink/compat.git;destsuffix=compat;name=compat \
           git://github.com/TI-OpenLink/wl12xx.git;destsuffix=wl12xx;name=wl12xx \
           file://0001-git-version-use-compat-base-tree.patch;patchdir=../wl12xx \
           file://0001-compat-wireless-add-pm_runtime_enabled.patch;patchdir=../compat \
           file://0001-wl12xx-additional-two-members-for-wl12xx_platform_da.patch;patchdir=../wl12xx \
          "

SRC_URI_append_am335x-evm = "file://0001-wl12xx-Decrease-number-of-RX-transactions.patch;patchdir=../wl12xx \
                             file://0002-wl12xx-Decrease-number-of-TX-transactions.patch;patchdir=../wl12xx \
"

EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB=${D}"

# Prevent sourceipk adjust_git function from running.
# This preserves the git repo until driver-select is ran.

adjust_git() {
    :
}

do_configure() {
    cd ${S}
    GIT_TREE="${WORKDIR}/wl12xx" GIT_COMPAT_TREE="${WORKDIR}/compat" ./scripts/admin-refresh.sh

    ./scripts/driver-select wl12xx

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
