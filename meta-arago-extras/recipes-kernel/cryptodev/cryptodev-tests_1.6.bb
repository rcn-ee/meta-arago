require cryptodev_${PV}.inc

SUMMARY = "Linux Cryptodev Test Suite"
DESCRIPTION = "The Cryptodev package contains the test apps"

PR = "r0"
DEPENDS += "openssl"

SRC_URI += "file://Add-the-compile-and-install-rules-for-cryptodev-test.patch"

do_compile() {
	oe_runmake testprogs
}

do_install() {
	oe_runmake install_tests
}

FILES_${PN}-dbg += "${bindir}/tests_cryptodev/.debug"
FILES_${PN} = "${bindir}/tests_cryptodev/*"
