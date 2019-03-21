SUMMARY = "Embedded Linux Device Driver Tests based on Linux Test Project"
HOMEPAGE = "http://arago-project.org/git/projects/test-automation/ltp-ddt.git"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PR = "r2"
PV_append = "+git${SRCPV}"

PROVIDES += "ltp"
DEPENDS = "alsa-lib attr libaio libcap acl openssl zip-native"

RDEPENDS_${PN} = "\
    acl \
    at \
    attr \
    bash \
    cpio \
    cronie \
    curl \
    e2fsprogs-mke2fs \
    expect \
    gawk \
    gzip \
    iproute2 \
    ldd \
    libaio \
    logrotate \
    perl \
    pm-qa \
    python-core \
    serialcheck \
    unzip \
    util-linux \
    which \
    libgcc\
    memtester\
"

inherit autotools-brokensep

SRCREV = "4a41fb18e812088556f316852ed08c651b421c35"
BRANCH ?= "master"

SRC_URI = "git://arago-project.org/git/projects/test-automation/ltp-ddt.git;branch=${BRANCH} \
    file://0003-Add-knob-to-control-tirpc-support.patch \
"

S = "${WORKDIR}/git"

LTPROOT = "/opt/ltp"

# disable TI RPC (Transport-Independent RPC) due to missing dependency
EXTRA_OECONF += " --without-tirpc"

EXTRA_OEMAKE_append = " \
    prefix=${LTPROOT} \
    CROSS_COMPILE=${HOST_PREFIX} \
    SKIP_IDCHECK=1 \
    KERNEL_USR_INC=${STAGING_INCDIR} \
    ALSA_INCPATH=${STAGING_INCDIR} \
    ALSA_LIBPATH=${STAGING_LIBDIR} \
    RANLIB=${RANLIB} \
    DESTDIR=${D} \
    CC='${CC}' \
"

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN}-dbg += " \
    ${LTPROOT}/.debug \
    ${LTPROOT}/bin/.debug \
    ${LTPROOT}/runtest/.debug \
    ${LTPROOT}/testcases/bin/.debug \
    ${LTPROOT}/testcases/bin/*/bin/.debug \
    ${LTPROOT}/testcases/bin/*/test/.debug \
    ${LTPROOT}/testcases/bin/ddt/.debug \
    ${LTPROOT}/testcases/bin/ddt/*/bin/.debug \
    ${LTPROOT}/testcases/bin/ddt/*/test/.debug \
    ${LTPROOT}/testcases/realtime/*/*/.debug \
"

FILES_${PN}-staticdev += "${LTPROOT}/lib ${LTPROOT}/lib/libmem.a ${LTPROOT}/testcases/data/nm01/lib.a"
FILES_${PN} += "${LTPROOT}/*"

do_install() {
    oe_runmake install
}

# Avoid file dependency scans, as LTP checks for things that may or may not
# exist on the running system.  For instance it has specific checks for
# csh and ksh which are not typically part of OpenEmbedded systems (but
# can be added via additional layers.)
SKIP_FILEDEPS_${PN} = '1'
