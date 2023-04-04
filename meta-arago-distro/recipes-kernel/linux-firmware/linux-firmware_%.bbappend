PR_append = ".arago1"

PACKAGES =+ "${PN}-iwlwifi-9260"
PACKAGES =+ "${PN}-ibt-18"

LICENSE_${PN}-iwlwifi-9260 = "Firmware-iwlwifi_firmware"
LICENSE_${PN}-ibt-18 = "Firmware-ibt_firmware"

FILES_${PN}-iwlwifi-9260 = "${nonarch_base_libdir}/firmware/iwlwifi-9260-*.ucode"
FILES_${PN}-ibt-18 = "${nonarch_base_libdir}/firmware/intel/ibt-18-*.sfi ${nonarch_base_libdir}/firmware/intel/ibt-18-*.ddc"

RDEPENDS_${PN}-iwlwifi-9260 += "${PN}-iwlwifi-license"
RDEPENDS_${PN}-ibt-18 += "${PN}-ibt-license"

do_install_append() {
	rm -rf  ${D}/lib/firmware/ti-connectivity/
	rm -rf  ${D}/lib/firmware/cadence
}
