require ti-wifi-utils.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

PR_append ="c+gitr${SRCPV}"

# Tag: ol_R5.SP3.05
SRCREV = "e6dcb896facd7b3c422fd2bb4d10765ee691ceb4"

RDEPENDS_${PN}_am335x-evm_append = " wilink-calibrate"
