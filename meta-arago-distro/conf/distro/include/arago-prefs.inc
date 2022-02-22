# Set preferred Qt5 versions. Different namespace from Qt4, so no conflict
include conf/distro/include/qt5-versions.inc

# Use the latest version of ltp-ddt for kernel versions 3.8+
PREFERRED_PROVIDER_ltp-ddt = "ltp-ddt"

PREFERRED_PROVIDER_virtual/gettext = "gettext"

# OpenGLES/EGL/GBM preferences
# Most of existing TI platforms have SGX GPU core
PREFERRED_PROVIDER_virtual/egl = "ti-sgx-ddk-um"
PREFERRED_PROVIDER_virtual/libgles1 = "ti-sgx-ddk-um"
PREFERRED_PROVIDER_virtual/libgles2 = "ti-sgx-ddk-um"
PREFERRED_PROVIDER_virtual/libgbm = "ti-sgx-ddk-um"
PREFERRED_PROVIDER_virtual/gpudriver = "ti-sgx-ddk-km"

# J7 has a Rogue GPU core
PREFERRED_PROVIDER_virtual/egl:j7 = "ti-img-rogue-umlibs"
PREFERRED_PROVIDER_virtual/libgles1:j7 = "ti-img-rogue-umlibs"
PREFERRED_PROVIDER_virtual/libgles2:j7 = "ti-img-rogue-umlibs"
PREFERRED_PROVIDER_virtual/libgbm:j7 = "ti-img-rogue-umlibs"
PREFERRED_PROVIDER_virtual/gpudriver:j7 = "ti-img-rogue-driver"

PREFERRED_PROVIDER_virtual/kernel = "linux-ti-staging${ARAGO_KERNEL_SUFFIX}"

PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"

# Setting PREFERRED_VERSIONS due to selecting a specific version of a library or
# application that does not have a GPLv3 license
PREFERRED_VERSION_crda = "3.18"
PREFERRED_VERSION_obex = "0.34"

PREFERRED_PROVIDER_wpa-supplicant = "wpa-supplicant"
#PREFERRED_PROVIDER_wpa-supplicant:ti33x = "wpa-supplicant-wl18xx"
#PREFERRED_PROVIDER_wpa-supplicant:ti43x = "wpa-supplicant-wl18xx"
#PREFERRED_PROVIDER_wpa-supplicant:omap-a15 = "wpa-supplicant-wl18xx"
