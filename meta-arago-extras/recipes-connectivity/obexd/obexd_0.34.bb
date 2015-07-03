DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4 libical"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "files://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz \
"

SRC_URI[md5sum] = "36080a767e63e54878cd6bcfb20c4f3b"
SRC_URI[sha256sum] = "f99fb58562a3d7edef6fd9e63ca04510e241bbdab37fdb122c2c7a112a09100a"

inherit autotools-brokensep pkgconfig

PACKAGES =+ "obex-client obex-plugins"

FILES_${PN} += "${datadir}/dbus-1/services/${PN}.service"
FILES_obex-client = "${libexecdir}/obex-client \
                     ${datadir}/dbus-1/services/obex-client.service"
# currently the plugins are empty
FILES_obex-plugins = "${libdir}/obex/plugins"
