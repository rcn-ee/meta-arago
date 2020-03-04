DESCRIPTION = "Power management helper scripts"

require matrix-gui-apps-git.inc

LIC_FILES_CHKSUM := "file://../../${LICENSE_CHECKSUM}"
PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/power_apps/pm_generic_power"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/setclockspeed.sh ${D}${bindir}    
    install -m 0755 ${S}/warnonpm.sh ${D}${bindir}    
}
