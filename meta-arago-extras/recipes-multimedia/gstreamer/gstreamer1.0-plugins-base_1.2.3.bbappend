FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
        file://0001-Added-GstMetaDmaBuf-features.patch \
        file://0002-videoconvert-use-videoconvert-from-version-1.3.1-to-.patch \
"

PR_append = "-arago1"
