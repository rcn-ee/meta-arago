# The proper config doesn't currently exist anywhere in mainline U-boot.
# For now just use a similar config which is good enough for U-boot utilities.
UBOOT_CONFIG_am335x-hs-evm = "utils"
UBOOT_CONFIG[utils] = "am335x_evm_config"
UBOOT_MACHINE_am437x-hs-evm = "am43xx_evm_config"
UBOOT_MACHINE_dra7xx-hs-evm = "dra7xx_evm_config"
UBOOT_MACHINE_am57xx-hs-evm = "am57xx_evm_config"
UBOOT_MACHINE_k2e-hs-evm = "k2e_evm_config"
