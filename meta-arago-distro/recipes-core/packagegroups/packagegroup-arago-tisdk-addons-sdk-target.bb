DESCRIPTION = "Task to install headers and libraries related to addons into the SDK"
LICENSE = "MIT"
PR = "r15"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = "libdrm-dev"

UTILS_append_keystone = "\
	kernel-dev \
	libdnet-dev \
	libdnet-staticdev \
	binutils-dev \
	binutils-staticdev \
	elfutils-dev \
	elfutils-staticdev \
	libbz2-dev \
	libbz2-staticdev \
	boost-dev \
	libsdl-dev \
	"

TI_SECURE_STORAGE_DEV = "\
	ti-softhsmv2-dev \
	libp11-dev \
	libp11-staticdev \
	"

# Broken with 4.1
#	ipsecmgr-dev
#	ipsecmgr-staticdev
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
	hplib-dev \
	hplib-staticdev \
	nwal-lld-dev \
	nwal-lld-staticdev \
	pktlib-dev \
	pktlib-staticdev \
	netapi-dev \
	netapi-staticdev \
	libnl-xfrm-dev \
	libnl-xfrm-staticdev \
	libnl-dev \
	libnl-staticdev \
	ti-ipc-dev \
	ti-ipc-staticdev \
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

EXTRA_LIBS_append_k2l-evm = "\
	dfe-lld-dev \
	dfe-lld-staticdev \
	iqn2-lld-dev \
	iqn2-lld-staticdev \
	"

EXTRA_LIBS_append_k2hk-evm = "\
	srio-lld-dev \
	srio-lld-staticdev \
	ipc-transport-srio-dev \
	ipc-transport-srio-staticdev \
	mmap-lld \
	mmap-lld-staticdev \
	hyplnk-lld-dev \
	hyplnk-lld-staticdev \
	"

EXTRA_LIBS_append_k2e-evm = "\
	mmap-lld \
	mmap-lld-staticdev \
	hyplnk-lld-dev \
	hyplnk-lld-staticdev \
"

UTILS_append_omap3 = " canutils-dev"
UTILS_append_ti33x = " canutils-dev"
UTILS_append_ti43x = " canutils-dev"
UTILS_append_dra7xx = " canutils-dev \
                        opencl-staticdev \
"
UTILS_append_k2g-evm = " canutils-dev"

EXTRA_LIBS = ""
EXTRA_LIBS_append_omap-a15 = " cmem-dev"
EXTRA_LIBS_append_dra7xx = " libulm-dev \
                             libulm-staticdev \
                             gdbserver-c6x-dev \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${EXTRA_LIBS} \
"
