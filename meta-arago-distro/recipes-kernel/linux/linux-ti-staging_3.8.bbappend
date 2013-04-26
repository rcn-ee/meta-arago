MACHINE_KERNEL_PR_append = "-arago6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

require copy-defconfig.inc

KERNEL_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"

# The below lines are overlayed until the LOCALVERSION change is merged into
# the oe-core danny branch. Update: not coming to danny, keep until dylan.
kernel_do_configure_prepend() {
    if [ ! -e ${B}/.scmversion -a ! -e ${S}/.scmversion ]
    then
        echo ${KERNEL_LOCALVERSION} > ${B}/.scmversion
        echo ${KERNEL_LOCALVERSION} > ${S}/.scmversion
    fi
}
