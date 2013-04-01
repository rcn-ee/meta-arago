require ti-compat-bluetooth.inc

PR_append = "-r0"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/802/5435/ti-compat-bluetooth-2012-02-20.tar.gz \
           file://0001-compat-bluetooth-2.6-removed-unused-BT-modules-from-.patch \
           file://0002-Bluetooth-Fix-l2cap-conn-failures-for-ssp-devices.patch \
           file://0001-compat-bluetooth-fixing-kernel-panic-in-l2cap.patch \
"

SRC_URI[md5sum] = "7c231b35a2297391b5192f86ff4f10dd"
SRC_URI[sha256sum] = "d8882da8bb37821bfd0b9334b859f64d0ce82ae5262360367a3f3fdf31c7f350"
