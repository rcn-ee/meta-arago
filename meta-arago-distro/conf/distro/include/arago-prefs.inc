# Set *target* toolchain preferences at global distro level.
# Cross and SDK toolchain preferences are set in toolchain-*.inc files
GCCVERSION ?= "linaro-4.9%"
BINUVERSION ?= "linaro-2.25%"
GLIBCVERSION ?= "2.21%"
GLIBCINITVERSION ?= "2.21%"
LINUXLIBCVERSION ?= "4.1"

PREFERRED_VERSION_gcc ?= "${GCCVERSION}"
PREFERRED_VERSION_binutils ?= "${BINUVERSION}"
PREFERRED_VERSION_linux-libc-headers ?= "${LINUXLIBCVERSION}"
PREFERRED_VERSION_glibc ?= "${GLIBCVERSION}"
PREFERRED_VERSION_glibc-locale ?= "${GLIBCVERSION}"
PREFERRED_VERSION_glibc-initial ?= "${GLIBCINITVERSION}"

# Set preferred Qt5 versions. Different namespace from Qt4, so no conflict
include conf/distro/include/qt5-versions.inc

# Use the latest version of ltp-ddt for kernel versions 3.8+
PREFERRED_PROVIDER_ltp-ddt = "ltp-ddt"

# Use the latest version of libdrm
PREFERRED_VERSION_libdrm = "2.4.59"

PREFERRED_PROVIDER_virtual/gettext = "gettext"

ARAGO_QT_PROVIDER = "${@base_conditional('QT_PROVIDER','qt5','',base_contains('MACHINE_FEATURES','sgx','qt4-embedded-gles','qt4-embedded',d),d)}"
PREFERRED_PROVIDER_qt4-embedded = "${ARAGO_QT_PROVIDER}"

PREFERRED_VERSION_qt4-embedded = "4.8.5"
PREFERRED_VERSION_qt4-native = "4.8.5"
PREFERRED_VERSION_nativesdk-qt4-tools = "4.8.5"

# Use v4.09.00.01 of the Graphics SDK
PREFERRED_VERSION_omap3-sgx-modules_omap3 = "4.09.00.01"
PREFERRED_VERSION_libgles-omap3_omap3 = "4.09.00.01"

PREFERRED_PROVIDER_omap3-sgx-modules = "omap3-sgx-modules"
PREFERRED_PROVIDER_libgles-omap3 = "libgles-omap3"
PREFERRED_PROVIDER_libgles-omap3-dev = "libgles-omap3-dev"
PREFERRED_PROVIDER_libgles-omap3-dbg = "libgles-omap3-dbg"
PREFERRED_PROVIDER_virtual/egl = "libgles-omap3"
PREFERRED_PROVIDER_virtual/libgles1 = "libgles-omap3"
PREFERRED_PROVIDER_virtual/libgles2 = "libgles-omap3"

PREFERRED_PROVIDER_virtual/egl_omap-a15 = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_virtual/libgles1_omap-a15 = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_virtual/libgles2_omap-a15 = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_libgbm_omap-a15 = "libgbm"

PREFERRED_PROVIDER_virtual/egl_ti43x = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_virtual/libgles1_ti43x = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_virtual/libgles2_ti43x = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_libgbm_ti43x = "libgbm"

PREFERRED_PROVIDER_virtual/egl_ti33x = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_virtual/libgles1_ti33x = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_virtual/libgles2_ti33x = "omap5-sgx-ddk-um-linux"
PREFERRED_PROVIDER_libgbm_ti33x = "libgbm"

PREFERRED_PROVIDER_virtual/libgl = "mesa-gl"
PREFERRED_PROVIDER_virtual/mesa = "mesa-gl"

# This is required when using keystone devices with graphical support
# such as Qt5
PREFERRED_PROVIDER_virtual/egl_keystone = "mesa"
PREFERRED_PROVIDER_virtual/libgles1_keystone = "mesa"
PREFERRED_PROVIDER_virtual/libgles2_keystone = "mesa"
PREFERRED_PROVIDER_virtual/libgl_keystone = "mesa"
PREFERRED_PROVIDER_virtual/mesa_keystone = "mesa"

# Use the mainline u-boot recipe for TI devices unless overridden below
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"
PREFERRED_PROVIDER_u-boot = "u-boot"
PREFERRED_VERSION_u-boot = "2014.07"

# Use latest TI staging kernel and u-boot trees
PREFERRED_PROVIDER_virtual/bootloader_keystone = "u-boot-keystone"
PREFERRED_PROVIDER_u-boot_keystone = "u-boot-keystone"
PREFERRED_VERSION_linux-keystone = "3.10%"

PREFERRED_PROVIDER_virtual/kernel_am335x-evm = "linux-ti-staging"
PREFERRED_PROVIDER_virtual/kernel_am437x-evm = "linux-ti-staging"
PREFERRED_VERSION_linux-ti-staging = "4.1%"

PREFERRED_PROVIDER_virtual/bootloader_am335x-evm = "u-boot-ti-staging"
PREFERRED_PROVIDER_u-boot_am335x-evm = "u-boot-ti-staging"
PREFERRED_PROVIDER_virtual/bootloader_am437x-evm = "u-boot-ti-staging"
PREFERRED_PROVIDER_u-boot_am437x-evm = "u-boot-ti-staging"
PREFERRED_PROVIDER_virtual/bootloader_omap-a15 = "u-boot-ti-staging"
PREFERRED_PROVIDER_u-boot_omap-a15 = "u-boot-ti-staging"

PREFERRED_VERSION_u-boot-ti-staging = "2015.07%"

# Pin down udev version from oe-core, as meta-oe pulls in newer systemd-enhanced version
PREFERRED_VERSION_udev = "182"
PREFERRED_PROVIDER_udev = "udev"

# Set the PREFERRED_PROVIDER for jpeg functionality based on the MACHINE
# architecture.  For armv7a devices libjpeg-turbo should be used to take
# advantage of the SIMD instructions.
PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg_armv5te = "jpeg"

# Setting PREFERRED_VERSIONS due to selecting a specific version of a library or
# application that does not have a GPLv3 license
PREFERRED_VERSION_gdbm = "1.8.3"
PREFERRED_VERSION_readline = "5.2"
PREFERRED_VERSION_readline-native = "5.2"
PREFERRED_VERSION_readline-nativesdk = "5.2"

PREFERRED_VERSION_libnl = "3.2.25"
PREFERRED_VERSION_crda = "3.13"
PREFERRED_VERSION_obex = "0.34"
PREFERRED_VERSION_bash = "3.2.48"
PREFERRED_VERSION_gettext = "0.16.1"
PREFERRED_VERSION_elfutils = "0.148"
PREFERRED_VERSION_m4 = "1.4.9"

PREFERRED_PROVIDER_wpa-supplicant = "wpa-supplicant"
PREFERRED_PROVIDER_wpa-supplicant_ti33x = "wpa-supplicant-wl18xx"
PREFERRED_PROVIDER_wpa-supplicant_ti43x = "wpa-supplicant-wl18xx"
PREFERRED_PROVIDER_wpa-supplicant_omap-a15 = "wpa-supplicant-wl18xx"

PREFERRED_PROVIDER_gstreamer = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gstreamer-mm-accel', 'gstreamer', d)}"
PREFERRED_PROVIDER_gstreamer-dev = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gstreamer-mm-accel-dev', 'gstreamer-dev', d)}"
PREFERRED_PROVIDER_gstreamer-dbg = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gstreamer-mm-accel-dbg', 'gstreamer-dbg', d)}"
PREFERRED_PROVIDER_gst-plugins-bad = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-bad-mm-accel', 'gst-plugins-bad', d)}"
PREFERRED_PROVIDER_gst-plugins-bad-dev = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-bad-mm-accel-dev', 'gst-plugins-bad-dev', d)}"
PREFERRED_PROVIDER_gst-plugins-bad-meta = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-bad-mm-accel-meta', 'gst-plugins-bad-meta', d)}"
PREFERRED_PROVIDER_gst-plugins-base = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-base-mm-accel', 'gst-plugins-base', d)}"
PREFERRED_PROVIDER_gst-plugins-base-dev = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-base-mm-accel-dev', 'gst-plugins-base-dev', d)}"
PREFERRED_PROVIDER_gst-plugins-base-meta = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-base-mm-accel-meta', 'gst-plugins-base-meta', d)}"
PREFERRED_PROVIDER_gst-plugins-good = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-good-mm-accel', 'gst-plugins-good', d)}"
PREFERRED_PROVIDER_gst-plugins-good-dev = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-good-mm-accel-dev', 'gst-plugins-good-dev', d)}"
PREFERRED_PROVIDER_gst-plugins-good-meta = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-good-mm-accel-meta', 'gst-plugins-good-meta', d)}"

def filter_out(f, str, d):
    from re import match
    return " ".join(filter(lambda x: not match(f, x, 0), str.split()))
