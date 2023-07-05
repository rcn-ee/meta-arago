# Common pieces for Arago images

LICENSE = "MIT"

COMPATIBLE_MACHINE = "ti-soc"

IMAGE_FEATURES += "package-management splash"

# 4KB per 1 inode should be enough
EXTRA_IMAGECMD:ext2.gz += "-i 4096"

IMAGE_INSTALL = " \
	packagegroup-core-boot \
	${VIRTUAL-RUNTIME_initramfs} \
	${CORE_IMAGE_EXTRA_INSTALL} \
"

export IMAGE_BASENAME = "arago-image"

IMAGE_LINGUAS = ""

TOOLCHAIN_HOST_TASK:append = " nativesdk-buildtools-perl-dummy"
SDK_PACKAGE_ARCHS += "buildtools-dummy-${SDKPKGSUFFIX}"

BAD_RECOMMENDATIONS += " \
    ti-llvm3.6-dev \
    opencl-monitor-dev \
    libulm-dev \
    gdbserver-c6x-dev \
    coreutils \
    coreutils-dev \
"
BAD_RECOMMENDATIONS += "${@oe.utils.conditional("ARAGO_SYSVINIT", "1", "", "busybox-syslog", d)}"

inherit core-image remove-net-rules
