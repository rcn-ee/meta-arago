SUMMARY = "Task to add HMI related packages"
LICENSE = "MIT"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

HMI = " \
"


HMI_append_ti33x = " \
    evse-hmi \
"

HMI_append_ti43x = " \
    evse-hmi \
"

HMI_append_omap-a15 = " \
    evse-hmi \
"


RDEPENDS_${PN} = "\
	${HMI} \
"
