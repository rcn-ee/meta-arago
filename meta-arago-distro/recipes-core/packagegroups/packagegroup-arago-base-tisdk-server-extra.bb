DESCRIPTION = "Additional packages beyond console packages shared by TI SDKs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r9"

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

#    cmem-mod
#    cmem
#    mpm-transport
#    multiprocmgr
#    qmss-lld
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
    ti-ipc \
    rm-lld \
    demo-image-proc \
    pa-lld \
    hplib-mod \
    pktlib \
    cppi-lld \
    ipsecmgr-mod \
    "

# The following packages are not yet ready for k2g-evm
#    netapi
#    netapi-test
#    hplib
#    nwal-lld

ARAGO_TI_PKGS = ""
ARAGO_TI_PKGS_append_keystone = " ${ARAGO_TI_KEYSTONE_PKGS}"
ARAGO_TI_PKGS_append_k2l-evm = "\
    dfe-lld \
    iqn2-lld \
    netapi \
    netapi-test \
    hplib \
    nwal-lld \
    "

#    srio-lld
ARAGO_TI_PKGS_append_k2hk-evm = "\
    mmap-lld \
    hyplnk-lld \
    aif2-lld \
    netapi \
    netapi-test \
    hplib \
    nwal-lld \
    "

ARAGO_TI_PKGS_append_k2e-evm = "\
    mmap-lld \
    hyplnk-lld \
    netapi \
    netapi-test \
    hplib \
    nwal-lld \
    "

#    recovery-kernel
RDEPENDS_${PN} = "\
    ${ARAGO_LIBNL} \
    ${ARAGO_PERL} \
    ${ARAGO_NDISC6} \
    ${ARAGO_PYTHON} \
    ${ARAGO_TI_PKGS} \
    ptpd \
    vsftpd \
    syslog-ng \
    dtc \
    strongswan \
    procps \
    dhcp-client \
    ipsec-tools \
    kexec \
    kdump \
    tzdata \
    lksctp-tools \
    lksctp-tools-utils \
    libdnet \
    vtun \
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
    k2-initramfs \
    parse-ip \
    "
