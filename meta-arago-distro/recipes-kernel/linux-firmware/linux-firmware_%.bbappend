PR:append = ".arago1"

PACKAGES =+ "${PN}-iwlwifi-9260"
PACKAGES =+ "${PN}-ibt-18"

LICENSE:${PN}-iwlwifi-9260 = "Firmware-iwlwifi_firmware"
LICENSE:${PN}-ibt-18 = "Firmware-ibt_firmware"

FILES:${PN}-iwlwifi-9260 = "${nonarch_base_libdir}/firmware/iwlwifi-9260-*.ucode"
FILES:${PN}-ibt-18 = "${nonarch_base_libdir}/firmware/intel/ibt-18-*.sfi ${nonarch_base_libdir}/firmware/intel/ibt-18-*.ddc"

RDEPENDS:${PN}-iwlwifi-9260 += "${PN}-iwlwifi-license"
RDEPENDS:${PN}-ibt-18 += "${PN}-ibt-license"

do_install:append() {
	rm -rf  ${D}/lib/firmware/ti-connectivity/
}
