DESCRIPTION = "Linux Bluetooth Stack HCI Debugger Tool."
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "bluez4"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a \
                    file://src/hcidump.c;beginline=1;endline=23;md5=3bee3a162dff43a5be7470710b99fbcf"
PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/bluez-hcidump-${PV}.tar.gz"
S = "${WORKDIR}/bluez-hcidump-${PV}"

EXTRA_OECONF = "--with-bluez-libs=${STAGING_LIBDIR} --with-bluez-includes=${STAGING_INCDIR}"

inherit autotools

SRC_URI[md5sum] = "3c298a8be67099fe227f3e4d9de539d5"
SRC_URI[sha256sum] = "073066d3ec1f7d1c52bb0fe27cde84ea273e1ab3097b27fa1fd45a5992e1a441"

