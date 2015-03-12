DESCRIPTION = "Make dump file utility"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "http://sourceforge.net/projects/makedumpfile/files/makedumpfile/1.5.0/makedumpfile-${PV}.tar.gz;name=makedumpfile"

SRC_URI[makedumpfile.md5sum] = "e22277d77752c71525a79eab148abf55"
SRC_URI[makedumpfile.sha256sum] = "8a771a22c6ba79dc505e55727f0cfd357ccb3c97defe21cefd5a67b64452fca7"

DEPENDS = "zlib elfutils bzip2"

EXTRA_OEMAKE = "TARGET=${TARGET_ARCH}"

do_install() {
	install -d ${D}${bindir}/
	install -c -m 755 ${S}/makedumpfile ${D}${bindir}/
}
