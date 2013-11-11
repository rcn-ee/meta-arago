DESCRIPTION = "Utilities from Linaro for testing Power Management"
HOMEPAGE = "https://wiki.linaro.org/WorkingGroups/PowerManagement/Resources/TestSuite/PmQa"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PV = "0.4.4"
PR = "r0"

BRANCH ?= "master"
SRCREV = "fbc2762359b863dfbf4fd0bab1e8abd2a6125ed4"

SRC_URI = "git://git.linaro.org/tools/pm-qa.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/utils"

UTILS = "cpuburn cpucycle heat_cpu nanosleep"

CFLAGS += "-pthread"

do_compile () {
    oe_runmake
}

do_install () {
    install -d ${D}${bindir}

    for util in ${UTILS}
    do
        install -m 0755 $util ${D}${bindir}/
    done
}
