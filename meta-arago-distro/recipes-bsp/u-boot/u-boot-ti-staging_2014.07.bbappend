FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

PR_append = "-arago6"

UBOOT_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"

# AM57x EVM is currently on a seperate git tree/branch.
# Once the software has been integrated to the u-boot-ti-staging
# repository these lines can be removed.

OLD_BRANCH := "${BRANCH}"
SRC_URI_am57xx-evm := "${@oe_filter_out('git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${OLD_BRANCH}','${SRC_URI}', d)}"

BRANCH_am57xx-evm = "beaglex15"

SRC_URI_am57xx-evm += "git://github.com/felipebalbi/u-boot.git;protocol=git;branch=${BRANCH}"
SRC_URI_am57xx-evm += "file://0001-omap5-Add-netargs-and-netboot-option.patch"
