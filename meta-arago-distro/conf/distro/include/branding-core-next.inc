# Special "migration" branding for testing components that are to be updated in LTS migration

require branding-core.inc

PREFERRED_VERSION_linux-ti-staging = ""
PREFERRED_VERSION_linux-ti-staging-rt = ""
PREFERRED_VERSION_linux-ti-staging-systest = ""
PREFERRED_VERSION_u-boot-ti-staging = ""

# Auto rev important packages to pick up latest
SRCREV_pn-linux-ti-staging = "${AUTOREV}"
SRCREV_pn-linux-ti-staging-rt = "${AUTOREV}"
SRCREV_pn-linux-ti-staging-systest = "${AUTOREV}"
SRCREV_pn-u-boot-ti-staging = "${AUTOREV}"
