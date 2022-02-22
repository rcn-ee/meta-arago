# This fixes an issue with touchscreens not being detected with the default
# local.rules.  This can be removed when this change is picked up and
# meta-arago switches to Dora

# look for files in this layer first
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago5"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI:append = " \
                  file://usb1-rules.sh \
                  file://usb2-rules.sh"

do_install:append() {
    install -d ${D}/${bindir}

    install -m 0755 ${WORKDIR}/usb1-rules.sh ${D}${bindir}/usb1-rules.sh
    install -m 0755 ${WORKDIR}/usb2-rules.sh ${D}${bindir}/usb2-rules.sh
    ln -sf libudev.so.1 ${D}${base_libdir}/libudev.so.0
}
