DESCRIPTION = "BT GPIO Enable"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://gpio_en_am1808.c;beginline=1;endline=34;md5=fe94639d8f61c867d1bc4bf61473d3cd \
                    file://gpio_en_am335x.c;beginline=1;endline=34;md5=fe94639d8f61c867d1bc4bf61473d3cd \
                    file://gpio_en_omap3evm.c;beginline=1;endline=34;md5=fe94639d8f61c867d1bc4bf61473d3cd \
"
COMPATIBLE_MACHINE = "omap3|omapl138|ti33x"

PR = "${MACHINE_KERNEL_PR}"
PR_append = "a+gitr${SRCREV}"

SRCREV = "97c4600ff7d39f1cc6079939248cd9ed15100db4"

SRC_URI = "git://github.com/TI-ECS/bt_enable.git;protocol=git \
           file://0001-Makefile-Update-makefile-to-work-well-in-OE.patch \
"

S = "${WORKDIR}/git"

inherit module

INHIBIT_PACKAGE_STRIP = "1"

PLATFORM_ti33x = "am335x-evm"
PLATFORM_omap3 = "am37x-evm"
PLATFORM_omapl138 = "am180x-evm"

EXTRA_OEMAKE += "KERNEL_DIR=${STAGING_KERNEL_DIR} PLATFORM=${PLATFORM}"

do_install () {
    oe_runmake 'DEST_DIR=${D}' install
}
