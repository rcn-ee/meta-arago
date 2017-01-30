DESCRIPTION = "Test application for GC320 2D API"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://dra7x-sdk-ti-gc320-tests_manifest.html;md5=22a001855467f373c47f45de5330e3c9"

DEPENDS = "ti-gc320-libs"

BRANCH = "ti-${PV}"

SRC_URI = "git://git.ti.com/graphics/ti-gc320-test.git;protocol=git;branch=${BRANCH}"
SRCREV = "53207f8e360a3336276b62066a1d8a9e923de17e"
PR = "r2"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += "AQROOT=${S}/tests/src -f makefile.linux TOOLCHAIN_PATH=${TOOLCHAIN_PATH} CROSS_COMPILE=${TARGET_PREFIX} ARCH_TYPE=${TARGET_ARCH} CPU_TYPE=cortex-a15 VIVANTE_SDK_INC=${S}/sdk/include VIVANTE_SDK_LIB=${STAGING_DIR_TARGET}/usr/lib DESTDIR=${D} TARGET_PRODUCT=${TARGET_PRODUCT} LIBDIR=${libdir} SDK_DIR=${S}/build/tests/ EGL_API_FB=1"

do_install() {
	cd ${S}/tests/src/test/hal/common/UnitTest/galUtil
	oe_runmake install
	cd ${S}/tests/src/test/hal/common/UnitTest/units/gal2D/clear
	oe_runmake install
	cd ${S}/tests/src/test/hal/common/UnitTest/galRunTest2
	oe_runmake install

	install -d ${D}${bindir}/GC320/tests/unit_test/

	for file in ${S}/build/tests/samples/hal/unit_test/*; do
		install -m 755 $file ${D}${bindir}/GC320/tests/unit_test/
	done
}

INSANE_SKIP_${PN} += "ldflags"
