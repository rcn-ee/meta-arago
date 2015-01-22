DESCRIPTION = "Package containing scripts to setup the development host and target board"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://setup.sh;beginline=3;endline=31;md5=fc4b04a33df6d892c9f4d4a9d92b945e"

PR = "r21"

BRANCH ?= "master"
SRCREV = "e1ed2178043e097b7a8b2ea073473db732494845"
SRC_URI = "git://arago-project.org/git/projects/tisdk-setup-scripts.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/"

PACKAGE_ARCH = "${MACHINE_ARCH}"

UBOOT_ENV_am37x-evm = "setup-uboot-env-am37x.sh"
UBOOT_ENV_beagleboard = "setup-uboot-env-beagleboard.sh"
UBOOT_ENV_am3517-evm = "setup-uboot-env-am3517.sh"
UBOOT_ENV_am180x-evm = "setup-uboot-env-am18x.sh"
UBOOT_ENV_ti33x = "setup-uboot-env-am335x.sh"
UBOOT_ENV_ti43x = "setup-uboot-env-am43x.sh"
UBOOT_ENV_omap5-evm = "setup-uboot-env-omap5.sh"
UBOOT_ENV_am57xx-evm = "setup-uboot-env-am57xx-evm.sh"
UBOOT_ENV = "setup-uboot-unknown.sh"

do_install () {
    install -m 0755 ${S}/setup.sh ${D}/
    install -d ${D}/bin
    install -m 0755 ${S}/common.sh ${D}/bin
    install -m 0755 ${S}/setup-host-check.sh ${D}/bin
    install -m 0755 ${S}/setup-minicom.sh ${D}/bin
    install -m 0755 ${S}/setup-package-install.sh ${D}/bin
    install -m 0755 ${S}/setup-targetfs-nfs.sh ${D}/bin
    install -m 0755 ${S}/setup-tftp.sh ${D}/bin
    install -m 0755 ${S}/create-sdcard.sh ${D}/bin
    install -m 0755 ${S}/add-to-group.sh ${D}/bin
    install -m 0755 ${S}/${UBOOT_ENV} ${D}/bin/setup-uboot-env.sh
}

FILES_${PN} += "setup.sh"
