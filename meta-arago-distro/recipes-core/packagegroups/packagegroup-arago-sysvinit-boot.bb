require recipes-core/packagegroups/packagegroup-core-boot.bb

PR = "r0"

# Cannot use eudev:
#   "eudev was skipped: 'systemd' in DISTRO_FEATURES"
#VIRTUAL-RUNTIME_dev_manager = "eudev"
VIRTUAL-RUNTIME_dev_manager = ""
VIRTUAL-RUNTIME_init_manager = "sysvinit"
VIRTUAL-RUNTIME_initscripts = "initscripts"
VIRTUAL-RUNTIME_initramfs = "sysvinit-initramfs"
