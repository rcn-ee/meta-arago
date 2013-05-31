# This is a TI specific version of the wpa-supplicant recipe for use with the
# wl12xx wlan and bluetooth module.

require wpa-supplicant.inc

LIC_FILES_CHKSUM = "file://../COPYING;md5=c54ce9345727175ff66d17b67ff51f58 \
                    file://../README;md5=79cddd95f8b7539aced400f6aab996e9 \
                    file://wpa_supplicant.c;beginline=1;endline=17;md5=009c87d612d92175fe8cd1e93137bf42"

# Tag: ol_R5.00.18
SRCREV = "b228361c306aea007672cda115b2701907d8d685"
PR_append = "b+gitr${SRCPV}"

SRC_URI += "file://0001-wpa_supplicant-dbus-AP-Add-support-for-WPS-Internal-.patch;patchdir=.. "
