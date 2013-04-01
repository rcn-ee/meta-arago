require ti-compat-bluetooth.inc

PR_append = "-r0"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/865/5622/compat-bluetooth-wl12xx-2012-05-22-r5-18.tgz \
           file://0001-compat-bluetooth-2.6-removed-unused-BT-modules-from-.patch \
           file://0002-Bluetooth-Fix-l2cap-conn-failures-for-ssp-devices.patch \
           file://0001-compat-bluetooth-fixing-kernel-panic-in-l2cap.patch \
"

SRC_URI[md5sum] = "85118756a605ebd8f4fbff19995368a6"
SRC_URI[sha256sum] = "d250a6447de54f0776a12ca604bf2a2a48b022108b699de5008f48462e535393"
