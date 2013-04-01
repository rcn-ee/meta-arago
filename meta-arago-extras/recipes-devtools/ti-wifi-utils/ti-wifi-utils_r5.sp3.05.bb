require ti-wifi-utils.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

PR_append ="b+gitr${SRCPV}"

SRCREV = "ol_R5.SP3.05"

RDEPENDS_${PN}_am335x-evm_append = " wilink-calibrate"
