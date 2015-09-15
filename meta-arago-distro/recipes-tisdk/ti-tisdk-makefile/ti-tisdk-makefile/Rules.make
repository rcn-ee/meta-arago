#platform
PLATFORM=__PLATFORM__

#defconfig
DEFCONFIG=__DEFCONFIG__

#Architecture
ARCH=__ARCH__

#u-boot machine
UBOOT_MACHINE=__UBOOT_MACHINE__

#Points to the root of the TI SDK
export TI_SDK_PATH=__SDK__INSTALL_DIR__

#root of the target file system for installing applications
DESTDIR=__DESTDIR__

#Points to the root of the Linux libraries and headers matching the
#demo file system.
export LINUX_DEVKIT_PATH=$(TI_SDK_PATH)/linux-devkit

#Cross compiler prefix
export CROSS_COMPILE=$(LINUX_DEVKIT_PATH)/sysroots/__SDKMACHINE__-arago-linux/usr/bin/__TOOLCHAIN_PREFIX__

#Default CC value to be used when cross compiling.  This is so that the
#GNU Make default of "cc" is not used to point to the host compiler
export CC=$(CROSS_COMPILE)gcc

#Location of environment-setup file
export ENV_SETUP=$(LINUX_DEVKIT_PATH)/environment-setup

#The directory that points to the SDK kernel source tree
LINUXKERNEL_INSTALL_DIR=$(TI_SDK_PATH)/board-support/__KERNEL_NAME__

CFLAGS=__CFLAGS__

SDK_PATH_TARGET=$(TI_SDK_PATH)/__SDK_PATH_TARGET__
