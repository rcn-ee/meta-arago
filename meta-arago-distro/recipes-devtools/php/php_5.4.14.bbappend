# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago3"

SRC_URI_append = " file://fix-race-condition-during-install.patch"

SRC_URI_append_virtclass-native = " file://0001-php-native-Fix-host-contamination-issue.patch"

python __anonymous () {
    d.setVar("SRC_URI", d.getVar("SRC_URI").replace('http://www.php.net/distributions/php-${PV}.tar.bz2', 'http://museum.php.net/php5/php-${PV}.tar.bz2'))
}

# Work around to address the fact that php-fpm and php-cgi can not coexist
# php-cgi is used by Matrix and php-fpm is in beta for this version of php.
# Once this issue is fix in meta-oe the below won't be needed.
# Issue mentioned here: https://bugs.php.net/bug.php?id=60144

EXTRA_OECONF := "${@oe_filter_out('--enable-fpm', '${EXTRA_OECONF}', d)}"

PACKAGES := "${@oe_filter_out('${PN}-fpm', '${PACKAGES}', d)}"
PACKAGES := "${@oe_filter_out('${PN}-fpm-apache2', '${PACKAGES}', d)}"

do_install_prepend_pn-php() {
    # Add the below file even though we aren't going to use it.
    # do_install will complain and fail if this file isn't found.
    touch ${S}/sapi/fpm/init.d.php-fpm
}
