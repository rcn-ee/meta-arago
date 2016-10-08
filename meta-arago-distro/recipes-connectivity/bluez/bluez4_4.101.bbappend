PR_append = ".arago2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://bluez4-fix-synchronization-between-bluetoothd-and-dr.patch \
            file://0001-socket-enable-for-bluez-4_98.patch \
            file://0001-bluez-enable-source-interface.patch \
"
# udev 150-170 provide its on hid2hci tool and udev rules for it. Therefore,
# disabling hid2hci from bluez4.

EXTRA_OECONF_remove = "--enable-hid2hci"
EXTRA_OECONF_remove = "--disable-hidd"
EXTRA_OECONF_append = " --enable-hid"

DEPENDS += "libsndfile1"

# Add test/agent for testing
PACKAGES =+ "bluez4-agent"

do_install_append () {
    ${TARGET_SYS}-libtool --mode=install install -c 'test/agent' ${D}${bindir}/agent
}

FILES_bluez4-agent = "${bindir}/agent"
