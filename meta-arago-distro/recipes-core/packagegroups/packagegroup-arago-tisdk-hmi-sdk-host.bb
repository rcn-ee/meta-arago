SUMMARY = "Task to add HMI related sources into the SDK"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

HMI = ""

HMI_append_ti43x = " \
    evse-hmi-src \
    mmwavegesture-hmi-src \
"

HMI_append_ti33x = " \
    evse-hmi-src \
    protection-relays-hmi-src \
    mmwavegesture-hmi-src \
"


HMI_append_omap-a15 = " \
    evse-hmi-src \
    mmwavegesture-hmi-src \
"

HMI_append_k3 = " \
    evse-hmi-src \
    mmwavegesture-hmi-src \
"

RDEPENDS_${PN} = "\
    ${HMI} \
"
