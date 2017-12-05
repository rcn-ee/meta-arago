# Special "bleeding" branding for experimenting and testing unreleased components

require branding-core.inc

# Auto rev important packages to pick up latest
SRCREV_pn-linux-ti-staging = "${AUTOREV}"
SRCREV_pn-linux-ti-staging-rt = "${AUTOREV}"
SRCREV_pn-linux-ti-staging-systest = "${AUTOREV}"
SRCREV_pn-u-boot-ti-staging = "${AUTOREV}"

# Build and assemble TI-SDK, but don't package it
IMAGE_FSTYPES_pn-arago-core-tisdk-image = ""
