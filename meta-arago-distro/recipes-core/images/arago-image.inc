# Common pieces for Arago images

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_FEATURES += "package-management splash"

# 4KB per 1 inode should be enough
EXTRA_IMAGECMD_ext2.gz += "-i 4096"

ARAGO_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-core-boot \
	bash \
	udev-extraconf \
	${ARAGO_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "arago-image"

IMAGE_LINGUAS = ""

make_bootfiles_symlinks_relative() {
    for f in "${IMAGE_ROOTFS}/boot"/*
    do
        [ -L "$f" ] || continue

        l=$(readlink "$f")
        if [ "${l:0:6}" == "/boot/" ]
        then
            ln -sf "${l##/boot/}" "$f"
        elif ["${l:0:1}" == "/" ]
        then
            ln -sf "..$l" "$f"
        fi
    done
}

ROOTFS_POSTPROCESS_COMMAND += "make_bootfiles_symlinks_relative;"

inherit core-image
