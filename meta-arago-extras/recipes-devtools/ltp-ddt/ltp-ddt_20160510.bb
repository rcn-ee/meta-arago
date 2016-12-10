SUMMARY = "Embedded Linux Device Driver Tests based on Linux Test Project"
HOMEPAGE = "http://arago-project.org/git/projects/test-automation/ltp-ddt.git"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PR = "r9"
PV_append = "+git${SRCPV}"

PROVIDES += "ltp"
DEPENDS += "zip-native alsa-lib libaio"

RDEPENDS_${PN} += "pm-qa serialcheck"

inherit autotools-brokensep

SRCREV = "a45af5cba34a1eda75ec55b3259ca05d83dad9b6"
BRANCH ?= "master"

SRC_URI = "git://arago-project.org/git/projects/test-automation/ltp-ddt.git;branch=${BRANCH}"

S = "${WORKDIR}/git"

LTPROOT = "/opt/ltp"

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

FILES_${PN}-staticdev += "${LTPROOT}/lib"
FILES_${PN} += "${LTPROOT}/*"

# The makefiles make excessive use of make -C and several include testcases.mk
# which triggers a build of the syscall header. To reproduce, build ltp,
# then delete the header, then "make -j XX" and watch regen.sh run multiple
# times. Its easier to generate this once here instead.
do_compile_prepend () {
    ( make -C ${B}/testcases/kernel include/linux_syscall_numbers.h )
}

do_install() {
    oe_runmake install
}
