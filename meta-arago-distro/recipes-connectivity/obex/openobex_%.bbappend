PR_append = ".arago2"

# Add apps/obex_test for testing
do_configure_prepend() {
	sed -i -e 's:bin_PROGRAMS = irxfer obex_tcp irobex_palm3:bin_PROGRAMS = irxfer obex_tcp irobex_palm3 obex_test:g' ${S}/apps/Makefile.am
	( cd ${S}; autoreconf -f -i -s )
}

# tell the openobex configure script NOT to enable syslog and dump.
# enabling log and dump prints lots of debug messages and hex dump value during BT
# file transfer using openobex, due to which BT transfer get slow.

EXTRA_OECONF_remove = "--enable-syslog"
EXTRA_OECONF_remove = "--enable-dump"

# WiLink Bluetooth application build depends on libmisc.a.
do_install_append() {
	install -m 644 ${B}/apps/libmisc.a ${D}/${libdir}
}
