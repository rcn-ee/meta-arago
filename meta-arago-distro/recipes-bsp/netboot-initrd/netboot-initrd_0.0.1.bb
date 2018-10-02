SUMMARY = "Initramfs image for NFS boot"
DESCRIPTION = "Small image capable of mounting a newtwork root filesystem (NFS)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r1"

inherit core-image image_types

#by default include the kernel modules necessary to use a ASIX USB/Ethernet adapter
NETBOOT_KERNEL_MODULES ?= "dwc3 dwc3-omap asix xhci-plat-hcd extcon-usb-gpio phy-omap-usb2"

export IMAGE_BASENAME = "netboot-initramfs"

#generate an image that can be loaded by u-boot
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES} ${INITRAMFS_FSTYPES}.u-boot"

# include udev (used to load the kernel modules)
VIRTUAL-RUNTIME_dev_manager = "udev"

# List of packages to install
IMAGE_INSTALL = "\
  bash \
  busybox \
  udev \
  netboot-initrd-scripts\
  "

# add the required kernel modules
IMAGE_INSTALL += "${@' '.join(['kernel-module-'+x for x in d.getVar('NETBOOT_KERNEL_MODULES').split()])}"

# Reduce the size of the rootfs by removing features

# Do not include buysbox's syslog
BAD_RECOMMENDATIONS += "busybox-syslog"
# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""
# Keep extra language files from being installed
IMAGE_LINGUAS = ""

# To further reduce the size of the rootfs, remove the /boot directory from the final image
# this is usually done by adding RDEPENDS_kernel-base = "" in the configuration file. In our case we can't use
# this method. Instead we just wipe out the content of "/boot" before creating the image.
ROOTFS_POSTPROCESS_COMMAND += "empty_boot_dir; "
empty_boot_dir () {
	rm -rf ${IMAGE_ROOTFS}/boot/*
}
