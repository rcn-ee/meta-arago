# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago0"

# Add commit that fixes segementation fault when using -l option
SRC_URI += "file://bc-1.06-fixes-1.patch"
