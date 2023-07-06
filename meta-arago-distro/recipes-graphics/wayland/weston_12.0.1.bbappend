FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago1"

SRC_URI += " \
        file://0001-Revert-require-GL_EXT_unpack_subimage-commit.patch \
"

# required for weston user to interact with the render devices
inherit extrausers
EXTRA_USERS_PARAMS = " \
        usermod -aG render weston; \
"
