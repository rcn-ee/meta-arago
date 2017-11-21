SUMMARY = "CC-Link Industrial Ethernet Field Basic Master and Slave Implementation"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://CCIEF-BASIC_Master/library/include/SLMP.h;beginline=1;endline=34;md5=9bcca1b46fb3c83966c242e5afa3c352"

PV = "1.0"
PR = "r1"

CCIEF-BASIC_GIT_URI = "git://git.ti.com/processor-sdk/cclink.git"
CCIEF-BASIC_GIT_PROTOCOL = "git"
CCIEF-BASIC_GIT_BRANCH = "master"

CCIEF-BASIC_SRCREV = "ec2a42e61c85c6a5e858438c590b052f2e780d6f"

BRANCH = "${CCIEF-BASIC_GIT_BRANCH}"
SRC_URI = "${CCIEF-BASIC_GIT_URI};protocol=${CCIEF-BASIC_GIT_PROTOCOL};branch=${BRANCH}"

SRCREV = "${CCIEF-BASIC_SRCREV}"

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
# build Master sample application
    cd ${S}/CCIEF-BASIC_Master/build/linux
    oe_runmake
# build Slave sample application
    cd ${S}/CCIEF-BASIC_Slave/build/linux
    oe_runmake
}

do_install() {
# install CCIEF BASIC binaries
    install -d ${D}${bindir}
    install -m 755 ${S}/CCIEF-BASIC_Master/build/linux/Master_sample ${D}${bindir}
    install -m 755 ${S}/CCIEF-BASIC_Slave/build/linux/Slave_sample ${D}${bindir}

# install CCIEF BASIC configuration files
    install -d ${D}${datadir}/cclink
    install -m 644 ${S}/CCIEF-BASIC_Master/sample/MasterParameter.csv ${D}${datadir}/cclink
    install -m 644 ${S}/CCIEF-BASIC_Slave/sample/SlaveParameter.csv ${D}${datadir}/cclink
}

FILES_${PN} += "${datadir}/cclink"
