ARAGO_TISDK_IMAGE = "processor-sdk-linux-image"

# Set CMEM reserved memory region
RESERVE_CMEM = "${@bb.utils.contains('MACHINE_FEATURES','dsp','1','0',d)}"
CMEM_BASE_omap-a15 ?= "a0000000"
CMEM_SIZE_omap-a15 ?= "08000000"

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

SRCIPK_CUSTOM_GIT_BRANCH_pn-linux-ti-staging = "processor-sdk-local"
SRCIPK_CUSTOM_GIT_MESSAGE_pn-linux-ti-staging = "${SRCIPK_SHALLOW_GIT_COMMIT_MESSAGE}"
SRCIPK_SHALLOW_CLONE_pn-linux-ti-staging = "true"
SRCIPK_SHALLOW_DEPTH_pn-linux-ti-staging = "400"

SRCIPK_CUSTOM_GIT_BRANCH_pn-u-boot-ti-staging = "processor-sdk-local"
SRCIPK_CUSTOM_GIT_MESSAGE_pn-u-boot-ti-staging = "${SRCIPK_GIT_COMMIT_MESSAGE}"

# Temporarily disable "mmip" machine feature for all SOCs while building
# latest code base, until it is fixed for gstreamer 1.12
MACHINE_FEATURES := "${@d.getVar('MACHINE_FEATURES', True).replace('mmip', '')}"

# Temporarily disable UBI images for K2 "server" rootfs due to size
IMAGE_FSTYPES_remove_pn-tisdk-server-rootfs-image = "ubi ubifs"
