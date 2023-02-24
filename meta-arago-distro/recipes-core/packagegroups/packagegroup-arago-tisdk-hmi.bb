SUMMARY = "Task to add HMI related packages"
LICENSE = "MIT"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

HMI = " \
"


HMI:append:ti33x = " \
    evse-hmi \
    protection-relays-hmi \
    mmwavegesture-hmi \
"

HMI:append:ti43x = " \
    evse-hmi \
    mmwavegesture-hmi \
"

HMI:append:omap-a15 = " \
    evse-hmi \
    mmwavegesture-hmi \
"

HMI:append:am65xx = " \
    evse-hmi \
    mmwavegesture-hmi \
"

RDEPENDS:${PN} = "\
	${HMI} \
"
