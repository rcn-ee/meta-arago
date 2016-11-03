FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago4"

is_armv7 = "1"

SRCREV = "8dceff9b18e7c2e0cb879ea458e85a1806dff447"

EXTRA_OEMAKE = "CROSS_COMPILE_core=${HOST_PREFIX}  \
                CROSS_COMPILE_ta_arm32=${HOST_PREFIX}  \
                ta-targets=ta_arm32 \
                LIBGCC_LOCATE_CFLAGS=--sysroot=${STAGING_DIR_HOST} \
                CFG_TEE_TA_LOG_LEVEL=0 \
"

SRC_URI += " \
    file://0001-plat-ti-Fixed-issues-with-MMU-mapping.patch \
    file://0002-monitor-update-to-support-platform-services.patch \
    file://0003-plat-ti-Move-load-address-to-the-end-of-DRAM-and-inc.patch \
    file://0004-plat-ti-Add-DRA72x-platform-flavor.patch \
    file://0005-plat-ti-Add-DRA71x-EVM-platform-flavor.patch \
    file://0006-plat-ti-Add-AM57xx-EVM-platform-flavor.patch \
"

do_compile() {
    unset LDFLAGS
    export TI_SECURE_DEV_PKG=${TI_SECURE_DEV_PKG}
    for flavor in ${OPTEEFLAVOR}; do
        oe_runmake clean PLATFORM=${OPTEEMACHINE} PLATFORM_FLAVOR=$flavor
        oe_runmake all PLATFORM=${OPTEEMACHINE} PLATFORM_FLAVOR=$flavor
        ( cd out/arm-plat-${OPTEEOUTPUTMACHINE}/core/; \
            ${TI_SECURE_DEV_PKG}/scripts/secure-binary-image.sh tee.bin tee.bin.signed; \
            normfl=`echo $flavor | tr "_" "-"`
            mv tee.bin.signed $normfl.optee; \
        )
    done
}

do_install() {
    #install core on boot directory
    install -d ${D}/boot
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/*.optee ${D}/boot

    #install TA devkit
    install -d ${D}/usr/include/optee/export-user_ta/
    for f in  ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/export-ta_${OPTEE_ARCH}/* ; do
        cp -aR $f ${D}/usr/include/optee/export-user_ta/
    done
}

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/*.optee ${DEPLOYDIR}
}

FILES_${PN} = "/boot"
