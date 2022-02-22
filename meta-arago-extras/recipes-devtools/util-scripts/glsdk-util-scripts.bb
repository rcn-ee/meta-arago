DESCRIPTION = "Utility scripts for debug"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://debug/filter-dmesg-rproc.sh;md5=ce264e7cbc036fd2f37073947c2f0800"
PR = "r1"

COMPATIBLE_MACHINE = "omap-a15|j7"
PACKAGE_ARCH = "${MACHINE_ARCH}"
RDEPENDS:${PN} += "bash"

SRC_URI = "git://git.ti.com/glsdk/util-scripts.git"

SRCREV = "df50ca1592cae97ad0c7285686d602926b4f7305"

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    install -d ${D}${datadir}/ti/util-scripts
    install -d ${D}${datadir}/ti/util-scripts/debug
    install -d ${D}${datadir}/ti/util-scripts/perf
    install -d ${D}${datadir}/ti/util-scripts/demo
    install -m 755 ${S}/debug/* ${D}${datadir}/ti/util-scripts/debug/.
    install -m 755 ${S}/perf/* ${D}${datadir}/ti/util-scripts/perf/.
    install -m 755 ${S}/demo/* ${D}${datadir}/ti/util-scripts/demo/.

}

FILES:${PN} += "${datadir}/ti/util-scripts/*"
