DESCRIPTION = "Task to build and install header and libs into sdk"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

# Disable due to missing IPC in 4.1
#    packagegroup-arago-gst-sdk-target

RDEPENDS_${PN} = "\
"
