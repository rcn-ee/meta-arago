SUMMARY = "Prebuilt initramfs with apps for bootstraping new board"

LICENSE = "MIT"

CLEANBROKEN = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

BOOSTRAP_IMAGE = "tisdk-bootstrap-base-image"

TARGET = "bootstrap-rootfs-${MACHINE}.cpio"

do_install() {
	install -d ${D}/boot
	install -m 0644 ${DEPLOY_DIR_IMAGE}/${BOOSTRAP_IMAGE}-${MACHINE}.rootfs.cpio ${D}/boot/${TARGET}
}

FILES:${PN} = "/boot"

do_install[depends] = "${BOOSTRAP_IMAGE}:do_image_complete"
