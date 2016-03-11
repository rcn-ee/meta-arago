inherit image_types

COMPRESSIONTYPES += "gz.md5"
COMPRESS_CMD_gz.md5 = "${COMPRESS_CMD_gz}; md5sum ${IMAGE_NAME}.rootfs.${type}.gz > ${IMAGE_NAME}.rootfs.${type}.gz.md5"
IMAGE_TYPES += "tar.gz.md5"

COMPRESSIONTYPES += "xz.md5"
COMPRESS_CMD_xz.md5 = "${COMPRESS_CMD_xz}; md5sum ${IMAGE_NAME}.rootfs.${type}.xz > ${IMAGE_NAME}.rootfs.${type}.xz.md5"
IMAGE_TYPES += "tar.xz.md5"
