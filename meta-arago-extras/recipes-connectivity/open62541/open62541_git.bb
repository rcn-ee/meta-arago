SUMMARY = "Open source implementation of OPC UA"
HOMEPAGE = "http://open62541.org/"
LICENSE = "MPL-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/open62541/open62541.git;protocol=https;branch=${BRANCH} \
           git://github.com/OPCFoundation/UA-Nodeset.git;protocol=https;branch=v1.04;destsuffix=git/deps/ua-nodeset;name=ua-nodeset \
           git://github.com/Pro/mdnsd.git;protocol=https;branch=master;destsuffix=git/deps/mdnsd;name=mdnsd \
           file://0001-examples-client-allow-configurable-server.patch \
           file://0001-CMakeLists-do-not-install-git-directories.patch \
"

BRANCH = "1.0"
SRCREV = "e4309754fc2f6ea6508b59ca82e08c27b0118d74"

SRCREV_ua-nodeset = "0777abd1bc407b4dbd79abc515864f8c3ce6812b"
SRCREV_mdnsd = "f7f0dd543f12fa7bbf2b667cceb287b9c8184b7d"

SRCREV_FORMAT = "default"

PV = "1.0.1+git${SRCPV}"

inherit cmake python3native

DEPENDS += "python3-six-native"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=RelWithDebInfo -DUA_BUILD_EXAMPLES=1"

PACKAGECONFIG[sharedlibs] = "-DBUILD_SHARED_LIBS=1,-DBUILD_SHARED_LIBS=0,,"
PACKAGECONFIG[encrypt] = "-DUA_ENABLE_ENCRYPTION=1 -DMBEDTLS_FOLDER_LIBRARY=${STAGING_LIBDIR} -DMBEDTLS_FOLDER_INCLUDE=${STAGING_INCDIR},-DUA_ENABLE_ENCRYPTION=0,mbedtls,"
PACKAGECONFIG[pubsub] = "-DUA_ENABLE_PUBSUB=1,-DUA_ENABLE_PUBSUB=0,,"
PACKAGECONFIG[pubsub_uadp] = "-DUA_ENABLE_PUBSUB_ETH_UADP=1,-DUA_ENABLE_PUBSUB_ETH_UADP=0,,"
PACKAGECONFIG[pubsub_delta_frames] = "-DUA_ENABLE_PUBSUB_DELTAFRAMES=1,-DUA_ENABLE_PUBSUB_DELTAFRAMES=0,,"
PACKAGECONFIG[pubsub_informationmodel] = "-DUA_ENABLE_PUBSUB_INFORMATIONMODEL=1,-DUA_ENABLE_PUBSUB_INFORMATIONMODEL=0,,"
PACKAGECONFIG[pubsub_informationmodel_methods] = "-DUA_ENABLE_PUBSUB_INFORMATIONMODEL_METHODS=1,-DUA_ENABLE_PUBSUB_INFORMATIONMODEL_METHODS=0,,"
PACKAGECONFIG[subscription_events] = "-DUA_ENABLE_SUBSCRIPTIONS_EVENTS=1,-DUA_ENABLE_SUBSCRIPTIONS_EVENTS=0,,"
PACKAGECONFIG[certificate] = "-DUA_BUILD_SELFSIGNED_CERTIFICATE=1,-DUA_BUILD_SELFSIGNED_CERTIFICATE=0,,"

# Namespace zero: minimal, reduced (default), full
# 
# Allow all three options, but do not assume default, nor the behavior
#  if more than one option is chosen.
#
# NOTE: enabling ns0_full will cause a large increase in build time
PACKAGECONFIG[ns0_full] = "-DUA_NAMESPACE_ZERO=FULL,,,"
PACKAGECONFIG[ns0_reduced] = "-DUA_NAMESPACE_ZERO=REDUCED,,,"
PACKAGECONFIG[ns0_minimal] = "-DUA_NAMESPACE_ZERO=MINIMAL,,,"

# This is broken due to missing libsubunit dependency. Keep here in case it becomes available.
PACKAGECONFIG[unit_tests] = "-DUA_BUILD_UNIT_TESTS=1,-DUA_BUILD_UNIT_TESTS=0,libcheck libsubunit,"

PACKAGECONFIG ?= "pubsub pubsub_delta_frames pubsub_informationmodel \
                  pubsub_informationmodel_methods pubsub_uadp encrypt \
                  certificate"

# Install examples and unit tests
do_install:append() {
    # Install examples
    install -d "${D}${datadir}/${BPN}/examples"
    for example in ${B}/bin/examples/*
    do
        install -m 755 "$example" "${D}${datadir}/${BPN}/examples"
    done

    if ${@bb.utils.contains('PACKAGECONFIG','unit_tests','true','false',d)}
    then
        # Install unittests
        install -d "${D}${datadir}/${BPN}/tests"
        for test in ${B}/bin/tests/*
        do
            install -m 755 "$test" "${D}${datadir}/${BPN}/tests"
        done
    fi
}

PACKAGES =+ "${PN}-examples ${PN}-tests"
FILES:${PN}-dev += "${libdir}/cmake/* ${datadir}/${BPN}/tools"
FILES:${PN}-examples += "${datadir}/${BPN}/examples"
FILES:${PN}-tests += "${datadir}/${BPN}/tests"

# This contains some python-based tools
RDEPENDS:${PN}-dev = "python3"

# Allow staticdev package to be empty incase sharedlibs is switched on
ALLOW_EMPTY:${PN}-staticdev = "1"
ALLOW_EMPTY:${PN}-tests = "1"

BBCLASSEXTEND = "native nativesdk"
