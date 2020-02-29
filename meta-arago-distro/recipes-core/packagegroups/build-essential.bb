# This is just an alias between debian and OE names

LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = "packagegroup-core-buildessential"
