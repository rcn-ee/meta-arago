DESCRIPTION = "Task to install crypto dev packages in SDK"
LICENSE = "MIT"
PR = "r2"

inherit packagegroup

RDEPENDS_${PN} = "\
    openssl-dev \
    ocf-linux-dev \
"
