FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-extended/ltp/ltp:"
FILESEXTRAPATHS_prepend := "${ARAGOBASE}/meta-arago-extras/recipes-extended/ltp/ltp:"

require recipes-extended/ltp/ltp_${PV}.bb

SUMMARY = "Embedded Linux Device Driver Tests based on Linux Test Project"
HOMEPAGE = "http://arago-project.org/git/projects/test-automation/ltp-ddt.git"

PROVIDES += "ltp"

DEPENDS += "alsa-lib"

PE = "1"
PR = "r8"
PV_append = "+git${SRCPV}"

SRCREV = "d82d554074a480fa59a458c9690171fc46312e0d"
BRANCH ?= "master"

SRC_URI_remove = "git://github.com/linux-test-project/ltp.git"
SRC_URI_prepend = "git://arago-project.org/git/projects/test-automation/ltp-ddt.git;branch=${BRANCH} "

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
