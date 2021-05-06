SUMMARY = "Task to add HMI related sources into the SDK"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup features_check

REQUIRED_MACHINE_FEATURES = "gpu"

HMI = ""

HMI_append_ti43x = " \
    evse-hmi-source \
    mmwavegesture-hmi-source \
"

HMI_append_ti33x = " \
    evse-hmi-source \
    protection-relays-hmi-source \
    mmwavegesture-hmi-source \
"


HMI_append_omap-a15 = " \
    evse-hmi-source \
    mmwavegesture-hmi-source \
"

HMI_append_am65xx = " \
    evse-hmi-source \
    mmwavegesture-hmi-source \
"

RDEPENDS_${PN} = "\
    ${HMI} \
"
