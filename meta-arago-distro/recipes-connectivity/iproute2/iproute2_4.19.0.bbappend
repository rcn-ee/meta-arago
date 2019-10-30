PR_append = ".arago6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0001-add-support-for-prp-similar-to-hsr.patch \
    file://0002-hsr-prp-introduce-common-definitions-for-netlink-int.patch \
    file://0003-hsr-prp-refactor-common-code.patch \
    file://0004-hsr-prp-add-support-for-vlan-tagged-supervision-fram.patch \
    file://0001-utils-Implement-get_s64.patch \
    file://0002-include-Add-helper-to-retrieve-a-__s64-from-a-netlin.patch \
    file://0003-libnetlink-Add-helper-for-getting-a-__s32-from-netli.patch \
    file://0004-tc-Add-support-for-configuring-the-taprio-scheduler.patch \
    file://0005-taprio-Add-manpage-for-tc-taprio-8.patch \
    file://0006-taprio-Add-support-for-changing-schedules.patch \
    file://0007-taprio-Add-support-for-cycle_time-and-cycle_time_ext.patch \
    file://0008-utils-Fix-get_s64-function.patch \
    file://0009-taprio-Add-support-for-setting-flags.patch \
    file://0010-taprio-add-support-for-setting-txtime_delay.patch \
    file://0011-tc-taprio-Update-documentation.patch \
    file://0012-sync-pkt_sched-header-with-kernel-version.patch \
"
