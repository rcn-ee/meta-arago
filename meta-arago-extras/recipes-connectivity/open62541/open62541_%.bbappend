
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " file://0001-examples-client-allow-configurable-server.patch \
                   file://0001-examples-Remove-sys-io.h.patch \
"

EXTRA_OECMAKE = "-DUA_BUILD_EXAMPLES=1"

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

# Allow staticdev package to be empty incase sharedlibs is switched on
ALLOW_EMPTY:${PN}-staticdev = "1"
ALLOW_EMPTY:${PN}-tests = "1"

BBCLASSEXTEND = "native nativesdk"

