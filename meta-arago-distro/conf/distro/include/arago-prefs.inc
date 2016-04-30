# Set *target* toolchain preferences at global distro level.
# Cross and SDK toolchain preferences are set in toolchain-*.inc files
GCCVERSION ?= "linaro-5.2%"
BINUVERSION ?= "linaro-2.25%"
GLIBCVERSION ?= "2.23%"
GLIBCINITVERSION ?= "2.23%"
LINUXLIBCVERSION ?= "4.4"

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

PREFERRED_PROVIDER_virtual/gettext = "gettext"

PREFERRED_PROVIDER_virtual/egl = "ti-sgx-ddk-um"
PREFERRED_PROVIDER_virtual/libgles1 = "ti-sgx-ddk-um"
PREFERRED_PROVIDER_virtual/libgles2 = "ti-sgx-ddk-um"
PREFERRED_PROVIDER_libgbm = "libgbm"
PREFERRED_PROVIDER_libgbm-dev = "libgbm-dev"

PREFERRED_PROVIDER_virtual/libgl = "mesa-gl"
PREFERRED_PROVIDER_virtual/mesa = "mesa-gl"

# This is required when using keystone devices with graphical support
# such as Qt5
PREFERRED_PROVIDER_virtual/egl_keystone = "mesa"
PREFERRED_PROVIDER_virtual/libgles1_keystone = "mesa"
PREFERRED_PROVIDER_virtual/libgles2_keystone = "mesa"
PREFERRED_PROVIDER_virtual/libgl_keystone = "mesa"
PREFERRED_PROVIDER_virtual/mesa_keystone = "mesa"

PREFERRED_PROVIDER_virtual/kernel = "linux-ti-staging${ARAGO_KERNEL_SUFFIX}"
PREFERRED_VERSION_linux-ti-staging = "4.4%"

PREFERRED_PROVIDER_virtual/bootloader = "u-boot-ti-staging"
PREFERRED_PROVIDER_u-boot = "u-boot-ti-staging"
PREFERRED_VERSION_u-boot-ti-staging = "2016.05%"

# Pin down udev version from oe-core, as meta-oe pulls in newer systemd-enhanced version
PREFERRED_VERSION_eudev = "3.1.5"
PREFERRED_PROVIDER_eudev = "eudev"

PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"

# Setting PREFERRED_VERSIONS due to selecting a specific version of a library or
# application that does not have a GPLv3 license
PREFERRED_VERSION_gdbm = "1.8.3"
PREFERRED_VERSION_readline = "5.2"
PREFERRED_VERSION_readline-native = "5.2"
PREFERRED_VERSION_readline-nativesdk = "5.2"

PREFERRED_VERSION_libnl = "3.2.25"
PREFERRED_VERSION_crda = "3.18"
PREFERRED_VERSION_obex = "0.34"
PREFERRED_VERSION_bash = "3.2.48"
PREFERRED_VERSION_gettext = "0.16.1"
PREFERRED_VERSION_elfutils = "0.148"
PREFERRED_VERSION_m4 = "1.4.9"

PREFERRED_PROVIDER_wpa-supplicant = "wpa-supplicant"
PREFERRED_PROVIDER_wpa-supplicant_ti33x = "wpa-supplicant-wl18xx"
PREFERRED_PROVIDER_wpa-supplicant_ti43x = "wpa-supplicant-wl18xx"
PREFERRED_PROVIDER_wpa-supplicant_omap-a15 = "wpa-supplicant-wl18xx"

def filter_out(f, str, d):
    from re import match
    return " ".join(filter(lambda x: not match(f, x, 0), str.split()))
