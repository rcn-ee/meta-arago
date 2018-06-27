FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago0"

PV = "3.1.0+git${SRCPV}"

is_armv7 = "1"
is_armv7_aarch64 = "0"

SRC_URI = "git://git.ti.com/optee/ti-optee-os.git;branch=${BRANCH} \
           file://0001-allow-setting-sysroot-for-libgcc-lookup.patch \
"
BRANCH = "master"
SRCREV = "940a24375ba5357d34fea7196dba48eadaee9abd"

ARMCORE = "CFG_ARM32_core=y ta-targets=ta_arm32"
ARMCORE_aarch64 = "CFG_ARM64_core=y ta-targets=ta_arm64"

EXTRA_OEMAKE = "CROSS_COMPILE_core=${HOST_PREFIX} \
                CROSS_COMPILE_ta_arm32=${HOST_PREFIX} \
                CROSS_COMPILE_ta_arm64=${HOST_PREFIX} \
                NOWERROR=1 \
                LIBGCC_LOCATE_CFLAGS=--sysroot=${STAGING_DIR_HOST} \
                CFG_TEE_TA_LOG_LEVEL=0 \
                CFG_TEE_CORE_LOG_LEVEL=2 \
                ${ARMCORE} \
"

CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
CPPFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

do_configure[noexec] = "1"

do_compile() {
    export TI_SECURE_DEV_PKG=${TI_SECURE_DEV_PKG}
    oe_runmake all PLATFORM=${OPTEEMACHINE} PLATFORM_FLAVOR=${OPTEEFLAVOR}
    ( cd out/arm-plat-${OPTEEOUTPUTMACHINE}/core/; \
        ${TI_SECURE_DEV_PKG}/scripts/secure-binary-image.sh tee.bin tee.bin.signed; \
        normfl=`echo ${OPTEEFLAVOR} | tr "_" "-"`
        mv tee.bin.signed $normfl.optee; \
    )

    if [ "${OPTEEPAGER}" = "y" ]; then
        oe_runmake clean PLATFORM=${OPTEEMACHINE} PLATFORM_FLAVOR=${OPTEEFLAVOR}
        oe_runmake all PLATFORM=${OPTEEMACHINE} PLATFORM_FLAVOR=${OPTEEFLAVOR} CFG_WITH_PAGER=y
        ( cd out/arm-plat-${OPTEEOUTPUTMACHINE}/core/; \
            ${TI_SECURE_DEV_PKG}/scripts/secure-binary-image.sh tee.bin tee.bin.signed; \
            normfl=`echo ${OPTEEFLAVOR} | tr "_" "-"`
            mv tee.bin.signed $normfl-pager.optee; \
        )
    fi
}

do_compile_aarch64() {
    oe_runmake all PLATFORM=${OPTEEMACHINE} PLATFORM_FLAVOR=${OPTEEFLAVOR}
    ( cd out/arm-plat-${OPTEEOUTPUTMACHINE}/core/; \
        mv tee-pager.bin bl32.bin; \
        mv tee.elf bl32.elf; \
    )
}

do_install() {
    #install core on boot directory
    install -d ${D}/boot
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/*.optee ${D}/boot || true
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/bl32.bin ${D}/boot || true
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/bl32.elf ${D}/boot || true

    #install TA devkit
    install -d ${D}/usr/include/optee/export-user_ta/
    for f in  ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/export-ta_${OPTEE_ARCH}/* ; do
        cp -aR $f ${D}/usr/include/optee/export-user_ta/
    done
}

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/*.optee ${DEPLOYDIR} || true
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/bl32.bin ${DEPLOYDIR} || true
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/bl32.elf ${DEPLOYDIR} || true
}

FILES_${PN} = "/boot"
SYSROOT_DIRS += "/boot"
