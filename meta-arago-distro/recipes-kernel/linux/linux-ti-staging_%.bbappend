MACHINE_KERNEL_PR_append = "-arago3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

require copy-defconfig.inc

KERNEL_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2]}"

kernel_do_configure_prepend() {
    if [ ! -e ${B}/.scmversion -a ! -e ${S}/.scmversion ]
    then
        echo ${KERNEL_LOCALVERSION} > ${B}/.scmversion
        echo ${KERNEL_LOCALVERSION} > ${S}/.scmversion
    fi
}
