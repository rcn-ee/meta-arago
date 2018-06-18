DESCRIPTION = "Additional packages beyond console packages shared by TI SDKs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r17"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARAGO_LIBNL = "\
    libnl-route \
    libnl-nf \
    libnl-genl \
    libnl-cli \
    "

ARAGO_PERL = "\
    perl \
    perl-module-carp \
    perl-module-class-struct \
    perl-module-errno \
    perl-module-exporter \
    perl-module-exporter-heavy \
    perl-module-fcntl \
    perl-module-file-spec \
    perl-module-file-spec-unix \
    perl-module-file-stat \
    perl-module-io-dir \
    perl-module-io-file \
    perl-module-io-handle \
    perl-module-io-pipe \
    perl-module-io-poll \
    perl-module-io-seekable \
    perl-module-io-select \
    perl-module-io-socket-inet \
    perl-module-io-socket-unix \
    perl-module-io-socket \
    perl-module-io \
    perl-module-list-util \
    perl-module-selectsaver \
    perl-module-socket \
    perl-module-strict \
    perl-module-symbol \
    perl-module-tie-handle \
    perl-module-tie-hash \
    perl-module-tie-stdhandle \
    perl-module-vars \
    perl-module-warnings-register \
    perl-module-warnings \
    perl-module-xsloader \
    "

ARAGO_NDISC6 = "\
    ndisc6-ndisc6 \
    ndisc6-rdisc6 \
    ndisc6-rltraceroute6 \
    ndisc6-tcpspray6 \
    ndisc6-tcptraceroute6 \
    ndisc6-tracert6 \
    "

ARAGO_PYTHON = "\
    python-core \
    python-io \
    python-ctypes \
    python-json \
    python-numpy \
    python-codecs \
    python-subprocess \
    python-pickle \
    python-shell \
    python-logging \
    python-mmap \
    python-profile \
    python \
    "

ARAGO_SECURE_STORAGE = "\
    ti-softhsmv2 \
    libp11 \
    engine-pkcs11 \
    "

# ipsecmgr has been disabled for a while
# disable ipsecmgr-mod,hplib-mod due to K4.14 API changes
#    ipsecmgr-mod
#    hplib-mod
ARAGO_TI_KEYSTONE_PKGS = "\
    ${ARAGO_SECURE_STORAGE} \
    uio-module-drv \
    traceframework \
    cuia \
    libnl-xfrm \
    udma \
    cuia \
    edma3-lld \
    srss-tc \
    cmem \
    cmem-mod \
    ti-ipc \
    mpm-transport \
    multiprocmgr \
    rm-lld \
    pa-lld \
    qmss-lld \
    pktlib \
    cppi-lld \
    k2-fw-initrd \
    parse-ip \
    "

# The following packages are not yet ready for k2g-evm
#    netapi
#    netapi-test
#    hplib
#    nwal-lld

ARAGO_TI_PKGS = ""
ARAGO_TI_PKGS_append_keystone = " ${ARAGO_TI_KEYSTONE_PKGS}"

# Disable netapi due to libnl and xfrm conflict
#    netapi
#    netapi-test
# Disable hplib,nwal-lld as hplib-mod is broken against K4.14
#    hplib
#    nwal-lld
ARAGO_TI_PKGS_append_k2l = "\
    dfe-lld \
    iqn2-lld \
    "

# Disable netapi due to libnl and xfrm conflict
#    netapi
#    netapi-test
# Disable hplib,nwal-lld as hplib-mod is broken against K4.14
#    hplib
#    nwal-lld
ARAGO_TI_PKGS_append_k2hk = "\
    srio-lld \
    mmap-lld \
    hyplnk-lld \
    aif2-lld \
    "

# Disable netapi due to libnl and xfrm conflict
#    netapi
#    netapi-test
# Disable hplib,nwal-lld as hplib-mod is broken against K4.14
#    hplib
#    nwal-lld
ARAGO_TI_PKGS_append_k2e = "\
    mmap-lld \
    hyplnk-lld \
    "

ARAGO_VTUN = "\
    vtun \
"
# vtun does not support aarch64
ARAGO_VTUN_aarch64 = ""

#    recovery-kernel
RDEPENDS_${PN} = "\
    ${ARAGO_LIBNL} \
    ${ARAGO_PERL} \
    ${ARAGO_NDISC6} \
    ${ARAGO_PYTHON} \
    ${ARAGO_TI_PKGS} \
    ${ARAGO_VTUN} \
    ptpd \
    vsftpd \
    syslog-ng \
    dtc \
    procps \
    dhcp-client \
    tzdata \
    lksctp-tools \
    lksctp-tools-utils \
    libdnet \
    bridge-utils \
    ebtables \
    rng-tools \
    elfutils \
    zip \
    libsdl \
    libgomp \
    libgomp-dev \
    file \
    libbz2 \
    boost \
    "
