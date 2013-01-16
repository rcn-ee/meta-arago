# Switch curl configuration from GnuTLS to OpenSSL
# per TSU exemption and export control restrictions

DEPENDS := "${@d.getVar('DEPENDS', True).replace('gnutls', '')}"
DEPENDS += "openssl"

EXTRA_OECONF += "\
            --with-ssl \
            --disable-ldap \
            --disable-ares \
            --disable-ipv6 \
            --enable-cookies \
            --enable-dict \
            --enable-file \
            --enable-ftp \
            --enable-http \
            --enable-telnet \
            --enable-tftp \
            "

CURLGNUTLS = "--without-gnutls"

PR_append = "-arago2"
