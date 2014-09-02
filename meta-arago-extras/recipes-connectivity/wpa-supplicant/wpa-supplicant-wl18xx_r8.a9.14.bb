# This is a TI specific version of the wpa-supplicant recipe for use with the
# wl18xx wlan module.

require wpa-supplicant.inc

LICENSE = "GPLv2 | BSD"
LIC_FILES_CHKSUM = "file://../COPYING;md5=ab87f20cd7e8c0d0a6539b34d3791d0e \
                    file://../README;md5=ba46b65db36e3c82244a3815b3738d63 \
                    file://wpa_supplicant.c;beginline=1;endline=17;md5=8835156c8ab8cad6356ec7f39ebe3aba"

FILESEXTRAPATHS_append := "${THISDIR}/wpa-supplicant:"

# Tag: ol_r8.a9.14
SRCREV = "281f5adb8eb7ee9e9220546c0227696b02aab332"
BRANCH = "single_hostap_dfs_dynamic"
PR_append = "c+gitr${SRCPV}"

# Add ti to the PV to indicate that this is a TI modify version of wpa-supplicant.
PV = "2.0-devel-ti"

PROVIDES += "wpa-supplicant"
RPROVIDES_${PN}  += "wpa-supplicant"
RREPLACES_${PN}  += "wpa-supplicant"
RCONFLICTS_${PN}  += "wpa-supplicant"
RDEPENDS_${PN} += "wpa-supplicant-cli wpa-supplicant-passphrase"
