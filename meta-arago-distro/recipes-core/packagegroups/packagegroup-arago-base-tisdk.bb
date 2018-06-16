DESCRIPTION = "Additional packages beyond console packages shared by TI SDKs"
LICENSE = "MIT"
PR = "r20"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

OPTEE_PKGS = " \
    optee-client \
    optee-test \
"

RDEPENDS_${PN} = "\
    dbus \
    expat \
    glib-2.0 \
    libxml2 \
    libpcre \
    iptables \
    iperf \
    arago-gpl-notice \
    arago-feed-config \
    nfs-utils-client \
    cifs-utils \
    ${@base_conditional('OPTEEMACHINE', 'ti', "${OPTEE_PKGS}", "", d)} \
"
