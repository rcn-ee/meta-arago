FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-extended/ltp/ltp:"

require recipes-extended/ltp/ltp_${PV}.bb

SUMMARY = "Embedded Linux Device Driver Tests based on Linux Test Project"
HOMEPAGE = "http://arago-project.org/git/projects/test-automation/ltp-ddt.git"

PROVIDES += "ltp"

DEPENDS += "alsa-lib"

PE = "1"
PR = "r2"
PV_append = "+git${SRCPV}"

SRCREV = "108cab23beb62a474b5a34fb2c6d9f6f5980b3ce"
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
