ARAGO_TISDK_IMAGE = "processor-sdk-linux-image"

# Remove wayland from ti33x and ti43x DISTRO_FEATURES.
DISTRO_FEATURES_remove_ti33x = "wayland"
DISTRO_FEATURES_remove_ti43x = "wayland"

# Set preferred providers and srcrevs
PREFERRED_PROVIDER_virtual/kernel_am335x-evm = "sitara-linux-ti-staging"
PREFERRED_PROVIDER_virtual/kernel_am437x-evm = "sitara-linux-ti-staging"
PREFERRED_VERSION_sitara-linux-ti-staging = "3.14%"

# Auto rev important packages to pick up latest
#SRCREV_pn-u-boot-ti-staging_omap-a15 = "${AUTOREV}"
#SRCREV_pn-ltp-ddt_omap-a15 = "${AUTOREV}"

# am3 and am4 use sitara-linux-ti-staging, so this only applies to omap-a15
#SRCREV_pn-linux-ti-staging = "${AUTOREV}"

# Freeze am3 and am4 u-boot
PREFERRED_PROVIDER_virtual/bootloader_am335x-evm = "u-boot-ti-staging"
PREFERRED_PROVIDER_u-boot_am335x-evm = "u-boot-ti-staging"
PREFERRED_VERSION_u-boot-ti-staging_am335x-evm = "2014.07%"
SRCREV_pn-u-boot-ti-staging_am335x-evm = "7e537bfdd261bf8bf444f3ac4d1be3db4ee124e8"

PREFERRED_PROVIDER_virtual/bootloader_am437x-evm = "u-boot-ti-staging"
PREFERRED_PROVIDER_u-boot_am437x-evm = "u-boot-ti-staging"
PREFERRED_VERSION_u-boot-ti-staging_am437x-evm = "2014.07%"
SRCREV_pn-u-boot-ti-staging_am437x-evm = "7e537bfdd261bf8bf444f3ac4d1be3db4ee124e8"


# To create newlines in the message \n is used and the slash must be escaped
# to function properly

SRCIPK_GIT_COMMIT_MESSAGE = "\
Create local branch\\n\
\\n\
The below commit is used for this local branch and is the one used by\\n\
this sdk:\\n\
${SRCREV}."

SRCIPK_SHALLOW_GIT_COMMIT_MESSAGE ="${SRCIPK_GIT_COMMIT_MESSAGE}\\n\\n\
To reduce the size of the SDK installer only a portion of the git commit\\n\
history has been preserved. Also links to remote branches and tags do\\n\
not exist in this copy of the repository.\\n\
To fix this please run the unshallow-repositories.sh\\n\
script located in the sdk\'s bin directory\\n\
\\n\
The script may take several minutes but you will then have a full copy of\\n\
the git repository including its entire git history.\\n"

SRCIPK_CUSTOM_GIT_BRANCH_pn-linux-ti-staging = "processor-sdk-1.0"
SRCIPK_CUSTOM_GIT_MESSAGE_pn-linux-ti-staging = "${SRCIPK_SHALLOW_GIT_COMMIT_MESSAGE}"

SRCIPK_CUSTOM_GIT_BRANCH_pn-sitara-linux-ti-staging = "processor-sdk-1.0"
SRCIPK_CUSTOM_GIT_MESSAGE_pn-sitara-linux-ti-staging = "${SRCIPK_SHALLOW_GIT_COMMIT_MESSAGE}"

SRCIPK_CUSTOM_GIT_BRANCH_pn-u-boot-ti-staging = "processor-sdk-1.0"
SRCIPK_CUSTOM_GIT_MESSAGE_pn-u-boot-ti-staging = "${SRCIPK_GIT_COMMIT_MESSAGE}"
