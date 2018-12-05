
# Common pieces for Arago images

LICENSE = "MIT"

COMPATIBLE_MACHINE = "ti-soc"

IMAGE_FEATURES += "package-management splash"

# 4KB per 1 inode should be enough
EXTRA_IMAGECMD_ext2.gz += "-i 4096"

# Install a small set of utils which can be used for diagnostics
ARAGO_TINY_IMAGE_EXTRA_INSTALL ?= "parted util-linux e2fsprogs dosfstools devmem2"

IMAGE_INSTALL += " \
	packagegroup-arago-sysvinit-boot \
	${ARAGO_TINY_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "arago-tiny-image"

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
