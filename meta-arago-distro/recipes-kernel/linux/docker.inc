FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://docker.cfg"
KERNEL_CONFIG_FRAGMENTS += "${WORKDIR}/docker.cfg"
