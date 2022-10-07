inherit image_types

COMPRESSIONTYPES += "gz.md5"
COMPRESS_CMD_gz.md5 = "${COMPRESS_CMD_gz}; md5sum ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${type}.gz > ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${type}.gz.md5"
IMAGE_TYPES += "tar.gz.md5"

COMPRESSIONTYPES += "xz.md5"
COMPRESS_CMD_xz.md5 = "${COMPRESS_CMD_xz}; md5sum ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${type}.xz > ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${type}.xz.md5"
IMAGE_TYPES += "tar.xz.md5"
