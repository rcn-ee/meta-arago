# Common pieces for Arago images

LICENSE = "MIT"

COMPATIBLE_MACHINE = "ti-soc"

IMAGE_FEATURES += "package-management splash"

# 4KB per 1 inode should be enough
EXTRA_IMAGECMD_ext2.gz += "-i 4096"

ARAGO_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-core-boot \
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

BAD_RECOMMENDATIONS += " \
    ti-llvm3.6-dev \
    opencl-monitor-dev \
    libulm-dev \
    gdbserver-c6x-dev \
    coreutils \
    coreutils-dev \
"

inherit core-image remove-net-rules
