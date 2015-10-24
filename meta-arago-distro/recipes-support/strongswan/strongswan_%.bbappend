PR_append = "-arago2"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS_remove = "gmp"

EXTRA_OECONF_remove = "--enable-gmp"

EXTRA_OECONF += "--disable-gmp \
        --enable-ctr \
        --enable-pkcs11 \
        --disable-tools \
"

SRC_URI += "file://pkcs11_plugin.conf"
