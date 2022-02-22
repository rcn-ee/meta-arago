# This is just an alias between debian and OE names

LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = "packagegroup-core-buildessential"
