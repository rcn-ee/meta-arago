# look for files in this layer first
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago1"

SRC_URI:append:virtclass-native = " file://0001-php-native-Fix-host-contamination-issue.patch"

# Work around to address the fact that php-fpm and php-cgi can not coexist
# php-cgi is used by Matrix and php-fpm is in beta for this version of php.
# Once this issue is fix in meta-oe the below won't be needed.
# Issue mentioned here: https://bugs.php.net/bug.php?id=60144

EXTRA_OECONF:remove = "--enable-fpm"

PACKAGES:remove = "${PN}-fpm"
PACKAGES:remove = "${PN}-fpm-apache2"

do_install:prepend:pn-php() {
    # Add the below file even though we aren't going to use it.
    # do_install will complain and fail if this file isn't found.
    mkdir -p ${B}/sapi/fpm/
    touch ${B}/sapi/fpm/init.d.php-fpm
}

INSANE_SKIP:${PN} += "installed-vs-shipped"
