SUMMARY = "Open source implementation of OPC UA"
HOMEPAGE = "http://open62541.org/"
LICENSE = "MPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/open62541/open62541.git;protocol=https;branch=${BRANCH} \
           git://github.com/OPCFoundation/UA-Nodeset.git;protocol=https;branch=v1.04;destsuffix=deps/ua-nodeset;name=ua-nodeset \
           git://github.com/Pro/mdnsd.git;protocol=https;branch=master;destsuffix=deps/mdnsd;name=mdnsd \
           file://0001-examples-client-allow-configurable-server.patch \
           file://0001-tests-fix-typing-of-size_t-in-printf.patch"

BRANCH = "master"
SRCREV = "7ea5a142bac44d5de7554938360e431d34fe2f59"

SRCREV_ua-nodeset = "5bbf784e9376f7230098149dc0218f318a48d630"
SRCREV_mdnsd = "9e953b8e4c54d50ba0e174f1e98cfca18f933126"

SRCREV_FORMAT = "default"

PV = "0.4-dev+git${SRCPV}"

inherit cmake python3native

DEPENDS += "python3-six-native libcheck"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=RelWithDebInfo -DUA_BUILD_EXAMPLES=1 -DUA_BUILD_UNIT_TESTS=1"

# Disable BUILD_OPTIMIZATION as unittests fail due to "strict-overflow"
DEBUG_BUILD = "1"
BUILD_OPTIMIZATION = ""
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Debug"

# Or disable unittests
#EXTRA_OECMAKE += "-DUA_BUILD_UNIT_TESTS=0"

PACKAGECONFIG[sharedlibs] = "-DBUILD_SHARED_LIBS=1,-DBUILD_SHARED_LIBS=0,,"
PACKAGECONFIG[encrypt] = "-DUA_ENABLE_ENCRYPTION=1 -DMBEDTLS_FOLDER_LIBRARY=${STAGING_LIBDIR} -DMBEDTLS_FOLDER_INCLUDE=${STAGING_INCDIR},-DUA_ENABLE_ENCRYPTION=0,mbedtls,"
PACKAGECONFIG[pubsub] = "-DUA_ENABLE_PUBSUB=1,-DUA_ENABLE_PUBSUB=0,,"
PACKAGECONFIG[pubsub_uadp] = "-DUA_ENABLE_PUBSUB_ETH_UADP=1,-DUA_ENABLE_PUBSUB_ETH_UADP=0,,"
PACKAGECONFIG[pubsub_delta_frames] = "-DUA_ENABLE_PUBSUB_DELTAFRAMES=1,-DUA_ENABLE_PUBSUB_DELTAFRAMES=0,,"
PACKAGECONFIG[pubsub_informationmodel] = "-DUA_ENABLE_PUBSUB_INFORMATIONMODEL=1,-DUA_ENABLE_PUBSUB_INFORMATIONMODEL=0,,"
PACKAGECONFIG[pubsub_informationmodel_methods] = "-DUA_ENABLE_PUBSUB_INFORMATIONMODEL_METHODS=1,-DUA_ENABLE_PUBSUB_INFORMATIONMODEL_METHODS=0,,"
PACKAGECONFIG[subscription_events] = "-DUA_ENABLE_SUBSCRIPTIONS_EVENTS=1,-DUA_ENABLE_SUBSCRIPTIONS_EVENTS=0,,"

PACKAGECONFIG[certificate] = "-DUA_BUILD_SELFSIGNED_CERTIFICATE=1,-DUA_BUILD_SELFSIGNED_CERTIFICATE=0,,"

PACKAGECONFIG ?= "pubsub pubsub_delta_frames pubsub_informationmodel \
                  pubsub_informationmodel_methods pubsub_uadp"

# Install examples and unit tests
do_install_append() {
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
ALLOW_EMPTY_${PN}-tests = "1"

BBCLASSEXTEND = "native nativesdk"
