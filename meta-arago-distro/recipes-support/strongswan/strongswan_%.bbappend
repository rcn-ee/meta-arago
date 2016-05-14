PR_append = ".arago3"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS_remove = "gmp"

EXTRA_OECONF_remove = "--enable-gmp"

EXTRA_OECONF += "--disable-gmp \
        --enable-ctr \
        --enable-pkcs11 \
        --disable-tools \
"

SRC_URI += "file://pkcs11_plugin.conf"

do_install_append () {
	install -m 0644 ${WORKDIR}/pkcs11_plugin.conf ${D}${sysconfdir}/strongswan.d/
}
