SUMMARY = "Task to install additional utilities for initial board bringup"
LICENSE = "MIT"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
	 arm-benchmarks \
	 evtest \
	 memtester \
	 nbench-byte \
	 pcitest \
	 serialcheck \
	 yavta \
	 hdparm \
	 i2c-tools \
	 libdrm-tests \
	 rt-tests \
	 iozone3 \
	 mtd-utils-ubifs-tests \
	 net-tools \
	 ethtool  \
	 pciutils \
	 rng-tools \
	 stress-ng \
	 iperf \
	 lmbench \
	 usbutils \
	 devmem2 \
	 phytool \
"

UTILS_append_ti33x = " \
    omapconf \
"

UTILS_append_ti43x = " \
    omapconf \
"

UTILS_append_omap-a15 = " \
    omapconf \
"

UTILS_append_k3 = " \
    k3conf \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
