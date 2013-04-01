# This is a TI specific version of the wpa-supplicant recipe for use with the
# wl12xx wlan and bluetooth module.

require wpa-supplicant.inc

LIC_FILES_CHKSUM = "file://../COPYING;md5=ab87f20cd7e8c0d0a6539b34d3791d0e \
                    file://../README;md5=5cb758942d25f6f61fd4ac388fd446fa \
                    file://wpa_supplicant.c;beginline=1;endline=17;md5=8835156c8ab8cad6356ec7f39ebe3aba"


SRCREV = "ol_R5.SP4.01"
PR_append = "a+gitr${SRCPV}"
