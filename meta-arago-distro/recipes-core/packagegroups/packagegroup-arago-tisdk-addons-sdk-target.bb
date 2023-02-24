DESCRIPTION = "Task to install headers and libraries related to addons into the SDK"
LICENSE = "MIT"
PR = "r44"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
	libdrm-dev \
	open62541-dev \
	open62541-staticdev \
	python3-numpy \
"

UTILS:append:ti33x = " can-utils-dev"
UTILS:append:ti43x = " can-utils-dev"
UTILS:append:dra7xx = " can-utils-dev \
                        elfutils-dev \
                        elfutils-staticdev \
"
UTILS:append:k3 = "\
	can-utils-dev \
	ti-rpmsg-char-dev \
	ti-rpmsg-char-staticdev \
"

EXTRA_LIBS = ""
EXTRA_LIBS:append:dra7xx = " libulm-dev \
                             libulm-staticdev \
                             gdbserver-c6x-dev \
"

PDM_ANOMALY_PKG_DEV = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'pdm-anomaly-detection-dev', '', d)} \
"


EXTRA_PACKAGES = ""
#EXTRA_PACKAGES:append:ti33x = " \
#                                arm-compute-library-dev \
#                                tensorflow-lite-dev \
#                                tensorflow-lite-staticdev \
#                                ${PDM_ANOMALY_PKG_DEV} \
#"
#EXTRA_PACKAGES:append:ti43x = " \
#                                arm-compute-library-dev \
#                                tensorflow-lite-dev \
#                                tensorflow-lite-staticdev \
#                                ${PDM_ANOMALY_PKG_DEV} \
#"
#EXTRA_PACKAGES:append:omap-a15 = " \
#                                arm-compute-library-dev \
#                                tensorflow-lite-dev \
#                                tensorflow-lite-staticdev \
#                                ${PDM_ANOMALY_PKG_DEV} \
#"
#EXTRA_PACKAGES:append:am65xx = " arm-compute-library-dev \
#                             tensorflow-lite-dev \
#                             tensorflow-lite-staticdev \
#                             ${PDM_ANOMALY_PKG_DEV} \
#"

IPCDEV = " \
	ti-ipc-dev \
	ti-ipc-staticdev \
"

EXTRA_PACKAGES:append:omap-a15 = " ${IPCDEV}"
EXTRA_PACKAGES:append:omapl138 = " ${IPCDEV}"

RDEPENDS:${PN} = "\
    ${UTILS} \
    ${EXTRA_LIBS} \
    ${EXTRA_PACKAGES} \
"
