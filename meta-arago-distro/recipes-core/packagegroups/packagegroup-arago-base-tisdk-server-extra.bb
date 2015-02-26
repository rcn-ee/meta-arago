DESCRIPTION = "Additional packages beyond console packages shared by TI SDKs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

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

ARAGO_TI_KEYSTONE_PKGS = "\
    ${ARAGO_SECURE_STORAGE} \
    uio-module-drv \
    multiprocmgr \
    mpm-transport \
    traceframework \
    cuia \
    hplib \
    hplib-mod \
    netapi \
    netapi-test \
    ipsecmgr-mod \
    libnl-xfrm \
    demo-image-proc \
    ti-ipc \
    rm-lld \
    cmem \
    cmem-mod \
    mmap-lld \
    udma \
    cuia \
    qmss-lld \
    pa-lld \
    cppi-lld \
    edma3-lld \
    hyplnk-lld \
    pktlib \
    nwal-lld \
    srss-tc \
    "

ARAGO_TI_PKGS = "\
    uio-module-drv \
    cmem \
    cmem-mod \
    "
ARAGO_TI_PKGS_append_keystone = "${ARAGO_TI_KEYSTONE_PKGS}"
ARAGO_TI_PKGS_append_k2l-evm = "\
    dfe-lld \
    iqn2-lld \
    "

ARAGO_TI_PKGS_append_k2hk-evm = "\
    srio-lld \
    "

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
    libgl \
	"
