PR_append = "-arago4"

UBOOT_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"

# the lines below can be removed once the U-Boot LOCALVERSION patches are merged
# into the oe-core danny branch. Update: not coming to danny, wait for dylan.
do_compile_prepend() {
    if [ ! -e ${B}/.scmversion -a ! -e ${S}/.scmversion ]
    then
        echo ${UBOOT_LOCALVERSION} > ${B}/.scmversion
        echo ${UBOOT_LOCALVERSION} > ${S}/.scmversion
    fi
}
