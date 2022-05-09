DESCRIPTION = "Utility scripts for debug"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://debug/filter-dmesg-rproc.sh;md5=ce264e7cbc036fd2f37073947c2f0800"

COMPATIBLE_MACHINE = "omap-a15|j7"
PACKAGE_ARCH = "${MACHINE_ARCH}"
RDEPENDS:${PN} += "bash"

SRC_URI = "git://git.ti.com/glsdk/util-scripts.git;branch=master"

SRCREV = "5a3f8eca444a5c4bf8855705a3018d482e3e19cd"

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
