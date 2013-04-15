MACHINE_KERNEL_PR_append = "-arago4"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

require copy-defconfig.inc

SRCREV = "${AUTOREV}"

KERNEL_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"

# The below lines are overlayed in this append until the dtb symlinks change
# is merged into the oe-core danny branch
pkg_postinst_kernel-devicetree () {
    cd /${KERNEL_IMAGEDEST}
    for DTS_FILE in ${KERNEL_DEVICETREE}
    do
        DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`
        DTB_SYMLINK_NAME=`echo ${KERNEL_IMAGE_SYMLINK_NAME} | sed "s/${MACHINE}/${DTS_BASE_NAME}/g"`
        update-alternatives --install /${KERNEL_IMAGEDEST}/${DTS_BASE_NAME}.dtb ${DTS_BASE_NAME}.dtb devicetree-${DTB_SYMLINK_NAME}.dtb ${KERNEL_PRIORITY} || true
    done
}

pkg_postrm_kernel-devicetree () {
    cd /${KERNEL_IMAGEDEST}
    for DTS_FILE in ${KERNEL_DEVICETREE}
    do
        DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`
        DTB_SYMLINK_NAME=`echo ${KERNEL_IMAGE_SYMLINK_NAME} | sed "s/${MACHINE}/${DTS_BASE_NAME}/g"`
        update-alternatives --remove ${DTS_BASE_NAME}.dtb devicetree-${DTB_SYMLINK_NAME}.dtb ${KERNEL_PRIORITY} || true
    done
}
