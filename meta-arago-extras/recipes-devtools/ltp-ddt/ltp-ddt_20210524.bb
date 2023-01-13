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

SRCREV = "4e613987b8dab09e64841631307123858ea44460"
BRANCH ?= "master"

SRC_URI_remove = "git://github.com/linux-test-project/ltp.git;protocol=https;branch=master"
SRC_URI_prepend = "git://git.ti.com/git/test-automation/ltp-ddt.git;protocol=https;branch=${BRANCH} "

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
