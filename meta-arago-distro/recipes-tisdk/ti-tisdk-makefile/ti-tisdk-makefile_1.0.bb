DESCRIPTION = "Package containing Makefile and Rules.make file for TISDKs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# Build the list of component makefiles to put together to build the
# Makefile that goes into the SDK.  For legacy devices the base Makefile
# will be picked up and will contain everything.
#
# It is assumed that the component makefiles follow the naming
# Makefile_$component.  All Makefiles will be part of the SRC_URI to be
# fetched, but only the listed ones will be used to build the final Makefile

SRC_URI = "\
    file://Makefile \
    file://Rules.make \
    file://Makefile_linux \
    file://Makefile_linux-dtbs \
    file://Makefile_u-boot-legacy \
    file://Makefile_matrix-gui \
    file://Makefile_arm-benchmarks \
    file://Makefile_ti-crypto-examples \
    file://Makefile_am-sysinfo \
    file://Makefile_av-examples \
    file://Makefile_u-boot-spl \
    file://Makefile_matrix-gui-browser \
    file://Makefile_refresh-screen \
    file://Makefile_pru \
    file://Makefile_ti-ocf-crypto-module \
    file://Makefile_qt-tstat \
    file://Makefile_quick-playground \
    file://Makefile_wireless \
    file://Makefile_omapconf \
    file://Makefile_oprofile-example \
"

PR = "r15"

MAKEFILES_COMMON = "linux \
                    matrix-gui \
                    arm-benchmarks \
                    am-sysinfo \
                    matrix-gui-browser \
                    refresh-screen \
                    qt-tstat \
                    oprofile-example \
"
MAKEFILES = ""

# This example application should not be used when using non-SGX
QUICK_PLAYGROUND = "${@base_conditional('ARAGO_QT_PROVIDER','qt4-embedded-gles','quick-playground','', d)}"

# Add device specific make targets

MAKEFILES_append_omap3 = " u-boot-spl \
                           ${QUICK_PLAYGROUND} \
"
MAKEFILES_append_am37x-evm = " av-examples \
                               ti-ocf-crypto-module \
                               wireless \
"
MAKEFILES_append_am3517-evm = " av-examples \
                                ti-ocf-crypto-module \
"
MAKEFILES_append_ti33x = " u-boot-spl \
                           ${QUICK_PLAYGROUND} \
                           wireless \
                           ti-crypto-examples \
"
MAKEFILES_append_ti43x = " u-boot-spl \
                           ${QUICK_PLAYGROUND} \
                           ti-crypto-examples \
"
MAKEFILES_append_omap-a15 = " u-boot-spl \
                              ${QUICK_PLAYGROUND} \
                              omapconf \
                              linux-dtbs \
"
MAKEFILES_append_am180x-evm = " pru \
                                u-boot-legacy \
                                wireless \
"

# Use ARCH format expected by the makefile
PLATFORM_ARCH = "armv7-a"
PLATFORM_ARCH_omapl138 = "armv5te"

# This step will stitch together the final Makefile based on the supported
# make targets.
do_install () {
    install -d ${D}/

    # Start with the base Makefile
    install  ${WORKDIR}/Makefile ${D}/Makefile

    # Remember the targets added so we can update the all target
    targets=""
    clean_targets=""
    install_targets=""

    # Now add common build targets
    for x in ${MAKEFILES_COMMON}
    do
        cat ${WORKDIR}/Makefile_${x} >> ${D}/Makefile
        targets="$targets""$x\ "
        clean_targets="$clean_targets""$x""_clean\ "
        install_targets="$install_targets""$x""_install\ "
    done

    # Now add device specific build targets
    for x in ${MAKEFILES}
    do
        cat ${WORKDIR}/Makefile_${x} >> ${D}/Makefile
        targets="$targets""$x\ "
        clean_targets="$clean_targets""$x""_clean\ "
        install_targets="$install_targets""$x""_install\ "
    done

    # Update the all, clean, and install targets if we added targets
    if [ "$targets" != "" ]
    then
        sed -i -e "s/__ALL_TARGETS__/$targets/" ${D}/Makefile
        sed -i -e "s/__CLEAN_TARGETS__/$clean_targets/" ${D}/Makefile
        sed -i -e "s/__INSTALL_TARGETS__/$install_targets/" ${D}/Makefile
    fi

    install  ${WORKDIR}/Rules.make ${D}/Rules.make

    # fixup Rules.make values
    sed -i -e "s/__PLATFORM__/${MACHINE}/" ${D}/Rules.make
    sed -i -e "s/__ARCH__/${PLATFORM_ARCH}/" ${D}/Rules.make
    sed -i -e "s/__TOOLCHAIN_PREFIX__/${TOOLCHAIN_SYS}-/" ${D}/Rules.make
    sed -i -e "s/__UBOOT_MACHINE__/${UBOOT_MACHINE}/" ${D}/Rules.make
    sed -i -e "s/__CFLAGS__/${TARGET_CC_ARCH}/" ${D}/Rules.make

}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "/*"
