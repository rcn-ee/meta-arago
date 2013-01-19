# This recipe is meant to be a temporary fix until we can figure out why
# the SD card partitions are not automounted anymore.

DESCRIPTION = "Script to mount SD card partitions when available"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# RDEPEND on udev since we re-use the mount.sh script
RDEPENDS_${PN} += "udev"

PACKAGE_ARCH = "all"

inherit update-rc.d

PR = "r0"

SRC_URI = "file://init"

INITSCRIPT_NAME = "mount-sdcard"

# Mount it early enough that other scripts can find the partitions.
INITSCRIPT_PARAMS = "defaults 90"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/mount-sdcard
}

FILES_${PN} = "${sysconfdir} ${bindir}"
