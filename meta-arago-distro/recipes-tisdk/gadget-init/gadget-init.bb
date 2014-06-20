# This recipe is based on the recipe by Koen in meta-texasinstruments
DESCRIPTION = "Scripts to initialize usb gadgets"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

COMPATIBLE_MACHINE = "ti33x"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r2"

SRC_URI = "file://init"

INITSCRIPT_NAME = "storage-gadget-init"
INITSCRIPT_PARAMS = "defaults 98"

inherit update-rc.d

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/storage-gadget-init
}

FILES_${PN} = "${sysconfdir} ${bindir}"
RRECOMMENDS_${PN} += "kernel-module-g-ether kernel-module-g-mass-storage"
