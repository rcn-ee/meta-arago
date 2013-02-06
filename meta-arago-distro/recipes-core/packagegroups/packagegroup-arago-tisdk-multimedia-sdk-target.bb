DESCRIPTION = "Task to build and install header and libs into sdk"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

RDEPENDS_${PN} = "\
    packagegroup-arago-gst-sdk-target \
"
