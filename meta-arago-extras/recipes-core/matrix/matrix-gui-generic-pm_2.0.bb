DESCRIPTION = "Power management helper scripts"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
PRIORITY = "optional"

require matrix-gui-apps-git.inc

LIC_FILES_CHKSUM := "file://../../${LICENSE_CHECKSUM}"
PR = "${INC_PR}.0"

PACKAGE_ARCH = "all"

S = "${WORKDIR}/git/power_apps/pm_generic_power"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/setclockspeed.sh ${D}${bindir}    
    install -m 0755 ${S}/warnonpm.sh ${D}${bindir}    
}
