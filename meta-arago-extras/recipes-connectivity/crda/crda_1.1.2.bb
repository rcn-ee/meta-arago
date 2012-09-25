DESCRIPTION = "Wireless Central Regulatory Domain Agent"
HOMEPAGE = "http://wireless.kernel.org/en/developers/Regulatory/CRDA"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=07c4f6dea3845b02a18dc00c8c87699c"

PR = "r0"

DEPENDS = "libgcrypt libnl python-native python-m2crypto-native"
RDEPENDS_${PN} = "udev"

SRC_URI = "http://wireless.kernel.org/download/crda/${P}.tar.bz2;name=crda \
	http://wireless.kernel.org/download/wireless-regdb/regulatory.bins/2011.04.28-regulatory.bin;name=reg \
	"

EXTRA_OEMAKE = "MAKEFLAGS="
do_compile() {
	oe_runmake all_noverify
}

do_install() {
	oe_runmake DESTDIR=${D} install
	install -d ${D}/usr/lib/crda/
	install -m 0644 ${WORKDIR}/2011.04.28-regulatory.bin ${D}/usr/lib/crda/regulatory.bin
}

SRC_URI[crda.md5sum] = "5226f65aebacf94baaf820f8b4e06df4"
SRC_URI[crda.sha256sum] = "e469348a5d0bb933df31995869130f68901de9be02e666437f52125698851864"
SRC_URI[reg.md5sum] = "1535e98bcaba732e2f8e8f62dac6f369"
SRC_URI[reg.sha256sum] = "bb6ba6f5dcdf7106a19c588b0e4d43ab7af26f6474fe01011a318b3dceaba33b"

FILES_${PN} += "\
	/lib/udev/rules.d/85-regulatory.rules \
	/usr/lib/crda/regulatory.bin \
	"
