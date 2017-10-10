DESCRIPTION = "Utility scripts for debug"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://debug/filter-dmesg-rproc.sh;md5=ce264e7cbc036fd2f37073947c2f0800"
PR = "r1"

COMPATIBLE_MACHINE = "omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://git.ti.com/glsdk/util-scripts.git"

SRCREV = "ecbb9cd13e1728686a82e87e5c1b325c0e806202"

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    install -d ${D}${datadir}/ti/util-scripts
    install -d ${D}${datadir}/ti/util-scripts/debug
    install -d ${D}${datadir}/ti/util-scripts/perf
    install -m 0644 ${S}/debug/* ${D}${datadir}/ti/util-scripts/debug/.
    install -m 0644 ${S}/perf/* ${D}${datadir}/ti/util-scripts/perf/.
}

FILES_${PN} += "${datadir}/ti/util-scripts/*"

