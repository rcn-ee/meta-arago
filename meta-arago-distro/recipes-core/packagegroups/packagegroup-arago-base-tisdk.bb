DESCRIPTION = "Additional packages beyond console packages shared by TI SDKs"
LICENSE = "MIT"
PR = "r17"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

OPTEE_PKGS = " \
    optee-os \
    optee-client \
    optee-test \
"

OPTEE_DEPS = ""
OPTEE_DEPS_am57xx-hs-evm = "${OPTEE_PKGS}"
OPTEE_DEPS_dra7xx-hs-evm = "${OPTEE_PKGS}"

RDEPENDS_${PN} = "\
    dbus \
    expat \
    glib-2.0 \
    libxml2 \
    libpcre \
    iptables \
    iperf3 \
    arago-gpl-notice \
    arago-feed-config \
    nfs-utils-client \
    ${OPTEE_DEPS} \
"
