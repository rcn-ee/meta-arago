inherit image_types

COMPRESSIONTYPES += "gz.md5"
COMPRESS_CMD_gz.md5 = "md5sum ${IMAGE_NAME}.rootfs.${type}.gz > ${IMAGE_NAME}.rootfs.${type}.gz.md5"
IMAGE_TYPES += "tar.gz.md5"
