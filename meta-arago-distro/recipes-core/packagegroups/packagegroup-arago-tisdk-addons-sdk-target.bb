DESCRIPTION = "Task to install headers and libraries related to addons into the SDK"
LICENSE = "MIT"
PR = "r40"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = "libdrm-dev \
         open62541-dev \
         open62541-staticdev \
         "

UTILS_append_keystone = "\
	kernel-dev \
	libdnet-dev \
	libdnet-staticdev \
	binutils-dev \
	binutils-staticdev \
	elfutils-dev \
	elfutils-staticdev \
	bzip2-dev \
	bzip2-staticdev \
	boost-dev \
	libsdl-dev \
	"

TI_SECURE_STORAGE_DEV = "\
	ti-softhsmv2-dev \
	libp11-dev \
	libp11-staticdev \
	"

# Disable ipsecmgr due to libnl and xfrm conflict
#	ipsecmgr-dev
#	ipsecmgr-staticdev
#	libnl-xfrm-dev
#	libnl-xfrm-staticdev
EXTRA_LIBS_append_keystone = "\
	${TI_SECURE_STORAGE_DEV} \
	cmem-dev \
	cmem-staticdev \
	udma-dev \
	udma-staticdev \
	traceframework-dev \
	traceframework-staticdev \
	cuia-dev \
	cuia-staticdev \
	common-csl-ip-dev \
	cppi-lld-dev \
	cppi-lld-staticdev \
	qmss-lld-dev \
	qmss-lld-staticdev \
	pa-lld-dev \
	pa-lld-staticdev \
	rm-lld-dev \
	rm-lld-staticdev \
	sa-lld-dev \
	sa-lld-staticdev \
	pktlib-dev \
	pktlib-staticdev \
	libnl-dev \
	libnl-staticdev \
	multiprocmgr-dev \
	multiprocmgr-staticdev \
	mpm-transport-dev \
	mpm-transport-staticdev \
	edma3-lld-dev \
	edma3-lld-staticdev \
	lksctp-tools-dev \
	lksctp-tools-staticdev \
	ipc-transport-qmss-dev \
	ipc-transport-qmss-staticdev \
	"

# Disable netapi due to libnl and xfrm conflict
#	netapi-dev
#	netapi-staticdev
# Disable hplib-dev/staticdev,nwal-lld due to hplib-mod breakage against K4.14
#	hplib-dev
#	hplib-staticdev
#	nwal-lld-dev
#	nwal-lld-staticdev
EXTRA_LIBS_append_k2l = "\
	dfe-lld-dev \
	dfe-lld-staticdev \
	iqn2-lld-dev \
	iqn2-lld-staticdev \
	"

# Disable netapi due to libnl and xfrm conflict
#	netapi-dev
#	netapi-staticdev
# Disable hplib-dev/staticdev,nwal-lld due to hplib-mod breakage against K4.14
#	hplib-dev
#	hplib-staticdev
#	nwal-lld-dev
#	nwal-lld-staticdev
EXTRA_LIBS_append_k2hk = "\
	srio-lld-dev \
	srio-lld-staticdev \
	ipc-transport-srio-dev \
	ipc-transport-srio-staticdev \
	mmap-lld \
	mmap-lld-staticdev \
	hyplnk-lld-dev \
	hyplnk-lld-staticdev \
	aif2-lld-dev \
	aif2-lld-staticdev \
	"

# Disable netapi due to libnl and xfrm conflict
#	netapi-dev
#	netapi-staticdev
# Disable hplib-dev/staticdev,nwal-lld due to hplib-mod breakage against K4.14
#	hplib-dev
#	hplib-staticdev
#	nwal-lld-dev
#	nwal-lld-staticdev
EXTRA_LIBS_append_k2e = "\
	mmap-lld \
	mmap-lld-staticdev \
	hyplnk-lld-dev \
	hyplnk-lld-staticdev \
"

UTILS_append_ti33x = " can-utils-dev"
UTILS_append_ti43x = " can-utils-dev"
UTILS_append_dra7xx = " can-utils-dev \
                        elfutils-dev \
                        elfutils-staticdev \
"
UTILS_append_k2g = " can-utils-dev"
UTILS_append_k3 = " can-utils-dev"

EXTRA_LIBS = ""
EXTRA_LIBS_append_ti43x = "\
    cmem-dev \
    cmem-staticdev \
"
EXTRA_LIBS_append_omap-a15 = " cmem-dev"
EXTRA_LIBS_append_dra7xx = " libulm-dev \
                             libulm-staticdev \
                             gdbserver-c6x-dev \
"
EXTRA_LIBS_append_k2hk = " libulm-staticdev \
                               gdbserver-c6x-dev \
"
EXTRA_LIBS_append_k2l = " libulm-staticdev \
                              gdbserver-c6x-dev \
"
EXTRA_LIBS_append_k2e = " libulm-staticdev \
                              gdbserver-c6x-dev \
"

EXTRA_PACKAGES = ""
EXTRA_PACKAGES_append_ti33x = " voxelsdk-dev \
                                arm-compute-library-dev \
                                armnn-dev \
"
EXTRA_PACKAGES_append_ti43x = " voxelsdk-dev \
                                arm-compute-library-dev \
                                armnn-dev \
"
EXTRA_PACKAGES_append_omap-a15 = " voxelsdk-dev \
                                arm-compute-library-dev \
                                armnn-dev \
"
EXTRA_PACKAGES_append_k3 = " arm-compute-library-dev \
                             armnn-dev \
"

IPCDEV = " \
	ti-ipc-dev \
	ti-ipc-staticdev \
"

EXTRA_PACKAGES_append_omap-a15 = " ${IPCDEV}"
EXTRA_PACKAGES_append_keystone = " ${IPCDEV}"
EXTRA_PACKAGES_append_omapl138 = " ${IPCDEV}"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${EXTRA_LIBS} \
    ${EXTRA_PACKAGES} \
"
