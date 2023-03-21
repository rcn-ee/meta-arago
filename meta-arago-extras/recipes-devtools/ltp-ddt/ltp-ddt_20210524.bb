FILESEXTRAPATHS:prepend := "${COREBASE}/meta/recipes-extended/ltp/ltp:"
FILESEXTRAPATHS:prepend := "${ARAGOBASE}/meta-arago-extras/recipes-extended/ltp/ltp:"

require recipes-extended/ltp/ltp_${PV}.bb

SUMMARY = "Embedded Linux Device Driver Tests based on Linux Test Project"
HOMEPAGE = "https://git.ti.com/cgit/test-automation/ltp-ddt/"

PROVIDES += "ltp"

DEPENDS += "alsa-lib"

PE = "1"
PR = "r7"
PV:append = "+git${SRCPV}"

SRCREV = "0b51638be46d1e00e2e7e6c4c65dcff738ff2e60"
BRANCH ?= "master"

SRC_URI:remove = "git://github.com/linux-test-project/ltp.git;protocol=https;branch=master"
SRC_URI:prepend = "git://git.ti.com/git/test-automation/ltp-ddt.git;protocol=https;branch=${BRANCH} "

export prefix = "/opt/ltp"
export exec_prefix = "/opt/ltp"

EXTRA_OEMAKE:append = " \
    KERNEL_USR_INC=${STAGING_INCDIR} \
    ALSA_INCPATH=${STAGING_INCDIR} \
    ALSA_LIBPATH=${STAGING_LIBDIR} \
"

RDEPENDS:${PN} += "\
    acl \
    at \
    pm-qa \
    serialcheck \
    memtester \
"

do_install:prepend() {
	# Upstream ltp recipe wants to remove this test case in do_install
	install -d ${D}${prefix}/runtest/
	echo "memcg_stress" >> ${D}${prefix}/runtest/controllers
}
