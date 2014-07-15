MACHINE_KERNEL_PR_append = "-arago1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

require copy-defconfig.inc

KERNEL_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"

SRCREV = "${AUTOREV}"

kernel_do_configure_prepend() {
    if [ ! -e ${B}/.scmversion -a ! -e ${S}/.scmversion ]
    then
        echo ${KERNEL_LOCALVERSION} > ${B}/.scmversion
        echo ${KERNEL_LOCALVERSION} > ${S}/.scmversion
    fi
}
