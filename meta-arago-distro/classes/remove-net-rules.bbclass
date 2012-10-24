# Add a ROOTFS_POSTPROCESS_COMMAND that will strip the write_net_rules
# executable from the file system.  This will prevent the
# 70-persistent-net.rules from being created.  Not having this file
# will allow moving SD cards between EVMs and similar boards such as
# beaglebone and the EVM.

ROOTFS_POSTPROCESS_COMMAND += "rootfs_remove_net_rules;"

rootfs_remove_net_rules () {
    if [ -e ${IMAGE_ROOTFS}/lib/udev/write_net_rules ]
    then
        rm ${IMAGE_ROOTFS}/lib/udev/write_net_rules
    fi
}

