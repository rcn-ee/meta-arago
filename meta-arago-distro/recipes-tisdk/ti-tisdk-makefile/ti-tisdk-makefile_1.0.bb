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
    file://Makefile_omapconf \
    file://Makefile_oprofile-example \
    file://Makefile_dual-camera-demo \
    file://Makefile_image-gallery \
    file://Makefile_cryptodev \
    file://Makefile_cmem-mod \
    file://Makefile_debugss-module-drv \
    file://Makefile_gdbserverproxy-module-drv \
    file://Makefile_ti-sgx-ddk-km \
    file://Makefile_opencl-examples \
    file://Makefile_boot-monitor \
    file://Makefile_hplib-mod \
    file://Makefile_uio-module-drv \
    file://Makefile_pru-icss \
    file://Makefile_qt-opencv-opencl-opengl-multithreaded \
    file://Makefile_ipsecmgr-mod \
    file://Makefile_openmpacc-examples \
    file://Makefile_linalg-examples \
    file://Makefile_ti-gc320-driver \
    file://Makefile_barcode-roi \
"

PR = "r87"

MAKEFILES_MATRIX_GUI = "matrix-gui-browser \
                        refresh-screen \
                        qt-tstat \
"

MAKEFILES_MATRIX_GUI_keystone = ""
MAKEFILES_MATRIX_GUI_omapl138 = ""
MAKEFILES_MATRIX_GUI_k3 = ""

MAKEFILES_COMMON = "linux \
                    matrix-gui \
                    arm-benchmarks \
                    am-sysinfo \
                    oprofile-example \
                    ${MAKEFILES_MATRIX_GUI} \
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
"
MAKEFILES_append_am3517-evm = " av-examples \
                                ti-ocf-crypto-module \
"
MAKEFILES_append_ti33x = " u-boot-spl \
                           ${QUICK_PLAYGROUND} \
                           ti-crypto-examples \
                           linux-dtbs \
                           cryptodev \
                           ti-sgx-ddk-km \
                           pru-icss \
                           barcode-roi \
                           uio-module-drv \
"
MAKEFILES_append_ti43x = " u-boot-spl \
                           ${QUICK_PLAYGROUND} \
                           ti-crypto-examples \
                           linux-dtbs \
                           cryptodev \
                           dual-camera-demo \
                           image-gallery \
                           ti-sgx-ddk-km \
                           cmem-mod \
                           pru-icss \
                           barcode-roi \
                           uio-module-drv \
"

MAKEFILES_append_dra7xx = " cryptodev \
                            debugss-module-drv \
                            gdbserverproxy-module-drv \
                            opencl-examples \
                            openmpacc-examples \
                            qt-opencv-opencl-opengl-multithreaded \
                            linalg-examples \
"

MAKEFILES_append_omap-a15 = " u-boot-spl \
                              ${QUICK_PLAYGROUND} \
                              omapconf \
                              linux-dtbs \
                              ti-sgx-ddk-km \
                              cmem-mod \
                              pru-icss \
                              ti-gc320-driver \
                              barcode-roi \
                              uio-module-drv \
"
MAKEFILES_append_omapl138 = " linux-dtbs \
                              u-boot-spl \
"

MAKEFILES_append_keystone = " u-boot-spl \
                              linux-dtbs \
                              boot-monitor \
                              cmem-mod \
                              cryptodev \
                              ti-crypto-examples \
                              hplib-mod \
                              uio-module-drv \
                              ipsecmgr-mod \
                              barcode-roi \
"

MAKEFILES_append_k2hk = " opencl-examples \
                              gdbserverproxy-module-drv \
                              debugss-module-drv \
                              openmpacc-examples \
                              linalg-examples \
"

MAKEFILES_append_k2l = " opencl-examples \
                             gdbserverproxy-module-drv \
                             debugss-module-drv \
                             openmpacc-examples \
"

MAKEFILES_append_k2e = " opencl-examples \
                             gdbserverproxy-module-drv \
                             debugss-module-drv \
                             openmpacc-examples \
"

MAKEFILES_append_k3 = " u-boot-spl \
                        linux-dtbs \
"

# Use this to export kernel arch to ARCH
#
# We need to be very careful here. This class will also overwrite UBOOT_ARCH
# even though it may be set in the machine configuration.
inherit kernel-arch

# Use ARCH format expected by the makefile
PLATFORM_ARCH = "${ARMPKGARCH}"
PLATFORM_ARCH_arm = "armv7-a"
PLATFORM_ARCH_omapl138 = "armv5te"

TARGET_PRODUCT = "jacinto6evm"
TARGET_PRODUCT_ti33x = "ti335x"
TARGET_PRODUCT_ti43x = "ti437x"

PLATFORM_DEBUGSS = ""
PLATFORM_DEBUGSS_dra7xx = "DRA7xx_PLATFORM"
PLATFORM_DEBUGSS_keystone = "KEYSTONE_PLATFORM"

PLATFORM_GDBSERVERPROXY = ""
PLATFORM_GDBSERVERPROXY_dra7xx = "DRA7xx_PLATFORM"
PLATFORM_GDBSERVERPROXY_keystone = "KEYSTONE_PLATFORM"

PRU_ICSS_INSTALL_TARGET = "pru-icss_install_none"
PRU_ICSS_INSTALL_TARGET_ti33x = "pru-icss_install_am335x"
PRU_ICSS_INSTALL_TARGET_ti43x = "pru-icss_install_am437x"
PRU_ICSS_INSTALL_TARGET_omap-a15 = "pru-icss_install_am572x"


# If it's not defined at all, like for zImage case
UBOOT_LOADADDRESS ?= "0"

KERNEL_BUILD_CMDS = "${@base_conditional('KERNEL_IMAGETYPE','uImage','LOADADDR=${UBOOT_LOADADDRESS}','',d)} ${KERNEL_IMAGETYPE}"

DEFCONFIG = "tisdk_${MACHINE}${ARAGO_KERNEL_SUFFIX}_defconfig"

AMSDK_DEFCONFIG = "singlecore-omap2plus_defconfig"

DEFCONFIG := "${@base_conditional('ARAGO_BRAND','amsdk','${AMSDK_DEFCONFIG}','${DEFCONFIG}',d)}"

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

    sed -i -e "s/__KERNEL_ARCH__/${ARCH}/" ${D}/Makefile
    sed -i -e "s/__KERNEL_BUILD_CMDS__/${KERNEL_BUILD_CMDS}/" ${D}/Makefile
    sed -i -e "s/__SDKMACHINE__/${SDKMACHINE}/g" ${D}/Makefile

    sed -i -e "s/__TARGET_PRODUCT__/${TARGET_PRODUCT}/" ${D}/Makefile
    sed -i -e "s/__PLATFORM_DEBUGSS__/${PLATFORM_DEBUGSS}/g" ${D}/Makefile
    sed -i -e "s/__PLATFORM_GDBSERVERPROXY__/${PLATFORM_GDBSERVERPROXY}/g" ${D}/Makefile
    sed -i -e "s/__BOOT_MONITOR_MAKE_TARGET__/${BOOT_MONITOR_MAKE_TARGET}/g" ${D}/Makefile
    sed -i -e "s/__PRU_ICSS_INSTALL_TARGET__/${PRU_ICSS_INSTALL_TARGET}/g" ${D}/Makefile

    cat ${D}/Makefile | grep "__DTB_DEPEND__" > /dev/null

    if [ "$?" == "0" ]
    then
        sed -i -e "s|__KERNEL_DEVICETREE__|${KERNEL_DEVICETREE}|" ${D}/Makefile
        sed -i -e "s/__DTB_DEPEND__/linux-dtbs/" ${D}/Makefile
        sed -i -e "s/__DTB_DEPEND_INSTALL__/linux-dtbs_install/" ${D}/Makefile
    else
        sed -i -e "s/__DTB_DEPEND__//" ${D}/Makefile
        sed -i -e "s/__DTB_DEPEND_INSTALL__//" ${D}/Makefile
    fi


    install  ${WORKDIR}/Rules.make ${D}/Rules.make

    # fixup Rules.make values
    sed -i -e "s/__PLATFORM__/${MACHINE}/" ${D}/Rules.make
    sed -i -e "s/__DEFCONFIG__/${DEFCONFIG}/" ${D}/Rules.make
    sed -i -e "s/__ARCH__/${PLATFORM_ARCH}/" ${D}/Rules.make
    sed -i -e "s/__TOOLCHAIN_PREFIX__/${TOOLCHAIN_SYS}-/" ${D}/Rules.make
    sed -i -e "s/__UBOOT_MACHINE__/${UBOOT_MACHINE}/" ${D}/Rules.make
    sed -i -e "s/__CFLAGS__/${TARGET_CC_ARCH}/" ${D}/Rules.make
    sed -i -e "s/__SDKMACHINE__/${SDKMACHINE}/" ${D}/Rules.make

}

do_install_append_k3() {
    cat >> ${D}/Rules.make << __EOF__

# Add CROSS_COMPILE and UBOOT_MACHINE for the R5
export CROSS_COMPILE_ARMV7=\$(LINUX_DEVKIT_PATH)/sysroots/${SDKMACHINE}-arago-linux/usr/bin/arm-linux-gnueabihf-
UBOOT_MACHINE_R5=am65x_evm_r5_defconfig
__EOF__
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "/*"
