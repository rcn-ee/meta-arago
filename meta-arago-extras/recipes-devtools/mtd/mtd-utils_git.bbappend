PR_append = ".arago1"

BBCLASSEXTEND += "nativesdk"

EXTRA_OEMAKE = "'CC=${CC} ${CFLAGS} ${@bb.utils.contains('PACKAGECONFIG', 'xattr', '', '-DWITHOUT_XATTR', d)} -I${S}/include' 'RANLIB=${RANLIB}' 'AR=${AR}' 'BUILDDIR=${S}'"

do_compile_append() {
	oe_runmake tests
}

do_install_append() {
	install -m 0755 io_update ${D}${sbindir}/
	install -m 0755 volrefcnt ${D}${sbindir}/
	install -m 0755 integ ${D}${sbindir}/
	install -m 0755 io_paral ${D}${sbindir}/
	install -m 0755 io_read ${D}${sbindir}/
	install -m 0755 io_basic ${D}${sbindir}/
	install -m 0755 mkvol_basic ${D}${sbindir}/
	install -m 0755 mkvol_bad ${D}${sbindir}/
	install -m 0755 mkvol_paral ${D}${sbindir}/
	install -m 0755 rsvol ${D}${sbindir}/
	install -m 0755 tests/ubi-tests/runtests.sh ${D}${sbindir}/
	install -m 0755 tests/ubi-tests/stress-test.sh ${D}${sbindir}/
}

PACKAGES =+ "mtd-utils-ubifs-tests"

FILES_mtd-utils-ubifs-tests = " \
${sbindir}/io_update \
${sbindir}/volrefcnt \
${sbindir}/integ \
${sbindir}/io_paral \
${sbindir}/io_read \
${sbindir}/io_basic \
${sbindir}/mkvol_basic \
${sbindir}/mkvol_bad \
${sbindir}/mkvol_paral \
${sbindir}/rsvol \
${sbindir}/runtests.sh \
${sbindir}/stress-test.sh \
"
