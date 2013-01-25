PR_append = "-arago1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

SRC_URI += "file://0001-obexd-fix-UTF-conversions.patch \
            file://0001-obexd-make-OPP-push-timeout-longer.patch \
"
