require branding-core.inc
QT_PROVIDER := "${@bb.utils.contains('SOC_FAMILY','omap-a15:dra7xx','qt5','qt4e',d)}"

PREFERRED_PROVIDER_virtual/kernel_am335x-evm = "sitara-linux-ti-staging"
PREFERRED_PROVIDER_virtual/kernel_am437x-evm = "sitara-linux-ti-staging"
PREFERRED_VERSION_sitara-linux-ti-staging = "3.14%"
