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
	 stress-ng \
	 iperf \
	 lmbench \
	 usbutils \
	 devmem2 \
	 phytool \
"

UTILS:append:ti33x = " \
    omapconf \
"

UTILS:append:ti43x = " \
    omapconf \
"

UTILS:append:omap-a15 = " \
    omapconf \
"

UTILS:append:k3 = " \
    k3conf \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
