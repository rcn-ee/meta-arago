PR_append = ".arago4"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PACKAGECONFIG = "charon curl openssl stroke sqlite3 \
        ${@bb.utils.filter('DISTRO_FEATURES', 'ldap', d)} \
"

EXTRA_OECONF += " \
        --enable-ctr \
        --enable-pkcs11 \
        --disable-tools \
"

SRC_URI += "file://pkcs11_plugin.conf"

do_install_append () {
	install -m 0644 ${WORKDIR}/pkcs11_plugin.conf ${D}${sysconfdir}/strongswan.d/
}
