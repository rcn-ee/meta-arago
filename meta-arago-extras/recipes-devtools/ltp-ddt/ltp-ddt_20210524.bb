FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-extended/ltp/ltp:"
FILESEXTRAPATHS_prepend := "${ARAGOBASE}/meta-arago-extras/recipes-extended/ltp/ltp:"

require recipes-extended/ltp/ltp_${PV}.bb

SUMMARY = "Embedded Linux Device Driver Tests based on Linux Test Project"
HOMEPAGE = "https://git.ti.com/cgit/test-automation/ltp-ddt/"

PROVIDES += "ltp"

DEPENDS += "alsa-lib"

PE = "1"
PR = "r7"
PV_append = "+git${SRCPV}"

SRCREV = "0ac70c1f1b1feaa6bc4c83b559ba0a7057911058"
BRANCH ?= "master"

SRC_URI_remove = "git://github.com/linux-test-project/ltp.git;protocol=https;branch=master"
SRC_URI_prepend = "git://git.ti.com/test-automation/ltp-ddt.git;branch=${BRANCH} "

export prefix = "/opt/ltp"
export exec_prefix = "/opt/ltp"

EXTRA_OEMAKE_append = " \
    KERNEL_USR_INC=${STAGING_INCDIR} \
    ALSA_INCPATH=${STAGING_INCDIR} \
    ALSA_LIBPATH=${STAGING_LIBDIR} \
"

RDEPENDS_${PN} += "\
    acl \
    at \
    pm-qa \
    serialcheck \
    memtester \
"

do_install_prepend() {
	# Upstream ltp recipe wants to remove this test case in do_install
	install -d ${D}${prefix}/runtest/
	echo "memcg_stress" >> ${D}${prefix}/runtest/controllers
}
