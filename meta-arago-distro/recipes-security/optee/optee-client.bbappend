PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-client.git;branch=${BRANCH} \
           file://tee-supplicant.service"

LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=69663ab153298557a59c67a60a743e5b"

PV = "3.5.0+git${SRCPV}"

BRANCH = "ti-optee-client"
SRCREV = "1f8f9abe4a31abd7b7490a7ddd9bbe812c92d5af"

do_install() {
    oe_runmake install

    install -D -p -m0755 ${S}/out/export${sbindir}/tee-supplicant ${D}${sbindir}/tee-supplicant

    install -D -p -m0644 ${S}/out/export${libdir}/libteec.so.1.0 ${D}${libdir}/libteec.so.1.0
    ln -sf libteec.so.1.0 ${D}${libdir}/libteec.so
    ln -sf libteec.so.1.0 ${D}${libdir}/libteec.so.1

    install -d ${D}${includedir}
    install -p -m0644 ${S}/out/export${includedir}/*.h ${D}${includedir}

    sed -i -e s:/etc:${sysconfdir}:g \
           -e s:/usr/bin:${bindir}:g \
              ${WORKDIR}/tee-supplicant.service

    install -D -p -m0644 ${WORKDIR}/tee-supplicant.service ${D}${systemd_system_unitdir}/tee-supplicant.service
}
