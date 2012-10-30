DESCRIPTION = "OBEX object pusher"
HOMEPAGE = "http://www.xmailserver.org/ussp-push.html"
SECTION = "console"
DEPENDS = "bluez4 openobex"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

PR = "r0"

SRC_URI = "http://www.xmailserver.org/ussp-push-${PV}.tar.gz \
	       file://hci_remote_name.patch"

S = "${WORKDIR}/ussp-push-${PV}"

EXTRA_OECONF = "--with-bluez-libs=${STAGING_LIBDIR} --with-bluez-includes=${STAGING_INCDIR}"

inherit autotools

SRC_URI[md5sum] = "5c44983ee27809867041feff6bb4423a"
SRC_URI[sha256sum] = "bb2748eaed6164812555b4a1e186c4f2820c5ef9ce30f12d7aac28a452719bbd"
