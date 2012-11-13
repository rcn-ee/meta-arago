PR_append = "-arago1"

# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

# Remove bash from the list of runtime dependencies
RDEPENDS_${PN} = "${PN}-ids"

SRC_URI += "file://usb-devices-avoid-dependency-on-bash.patch"
