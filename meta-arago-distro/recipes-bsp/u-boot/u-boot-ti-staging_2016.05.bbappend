# HS MLO
UBOOT_HS_MLO_BINARY = "u-boot_HS_MLO"
UBOOT_HS_MLO_IMAGE = "u-boot_HS_MLO-${MACHINE}-${PV}-${PR}"
UBOOT_HS_MLO_SYMLINK = "u-boot_HS_MLO-${MACHINE}"

do_install_append () {
	if [ -f ${S}/${UBOOT_HS_MLO_BINARY} ]; then
		install ${S}/${UBOOT_HS_MLO_BINARY} ${D}/boot/${UBOOT_HS_MLO_IMAGE}
		ln -sf ${UBOOT_HS_MLO_IMAGE} ${D}/boot/${UBOOT_HS_MLO_BINARY}
	fi
}

do_deploy_append () {
	if [ -f ${S}/${UBOOT_HS_MLO_BINARY} ]; then
		install ${S}/${UBOOT_HS_MLO_BINARY} ${DEPLOYDIR}/${UBOOT_HS_MLO_IMAGE}
		rm -f ${UBOOT_HS_MLO_BINARY} ${UBOOT_HS_MLO_SYMLINK}
		ln -sf ${UBOOT_HS_MLO_IMAGE} ${UBOOT_HS_MLO_SYMLINK}
		ln -sf ${UBOOT_HS_MLO_IMAGE} ${UBOOT_HS_MLO_BINARY}
	fi
}
