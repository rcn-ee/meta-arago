SUMMARY = "Open source implementation of OPC UA"
HOMEPAGE = "http://open62541.org/"
LICENSE = "MPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/open62541/open62541.git;protocol=https;branch=${BRANCH} \
           file://0001-examples-client-allow-configurable-server.patch"

BRANCH = "0.3"
SRCREV = "9f46963240854d9a65d1784a3d2d8440c70157e8"

PV = "0.3-rc4+git${SRCPV}"

inherit cmake python3native

DEPENDS += "python3-six-native libcheck"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=RelWithDebInfo -DUA_BUILD_EXAMPLES=1 -DUA_BUILD_UNIT_TESTS=1"

PACKAGECONFIG[sharedlibs] = "-DBUILD_SHARED_LIBS=1,-DBUILD_SHARED_LIBS=0,,"
PACKAGECONFIG[encrypt] = "-DUA_ENABLE_ENCRYPTION=1 -DMBEDTLS_FOLDER_LIBRARY=${STAGING_LIBDIR} -DMBEDTLS_FOLDER_INCLUDE=${STAGING_INCDIR},-DUA_ENABLE_ENCRYPTION=0,mbedtls,"

# Current mbedtls is not sufficient.
PACKAGECONFIG ?= ""

do_install_append() {
    # header file is not installed by default
    install -d ${D}${includedir}
    install -m 644 ${B}/open62541.h ${D}${includedir}

    # Install examples
    install -d "${D}${datadir}/${BPN}/examples"
    for example in ${B}/bin/examples/*
    do
        install -m 755 "$example" "${D}${datadir}/${BPN}/examples"
    done

    # Install unittests
    install -d "${D}${datadir}/${BPN}/tests"
    for test in ${B}/bin/tests/*
    do
        install -m 755 "$test" "${D}${datadir}/${BPN}/tests"
    done
}

PACKAGES =+ "${PN}-examples ${PN}-tests"
FILES_${PN}-dev += "${libdir}/cmake/*"
FILES_${PN}-examples += "${datadir}/${BPN}/examples"
FILES_${PN}-tests += "${datadir}/${BPN}/tests"

# Allow staticdev package to be empty incase sharedlibs is switched on
ALLOW_EMPTY_${PN}-staticdev = "1"

BBCLASSEXTEND = "native nativesdk"
