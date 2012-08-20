# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago0"

SRC_URI_append_virtclass-native = " file://0001-php-native-Fix-host-contamination-issue.patch"
