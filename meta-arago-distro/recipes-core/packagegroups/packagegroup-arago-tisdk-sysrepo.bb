SUMMARY = "Netopeer2 and Sysrepo packagegroup"
LICENSE = "MIT"

inherit packagegroup

ARAGO_NETOPEER_SYSREPO = "\
    sysrepo \
    netopeer2-server \
    nw-configurator \
    tsn-yang-models \
"

RDEPENDS:${PN} = "\
    ${ARAGO_NETOPEER_SYSREPO} \
"
