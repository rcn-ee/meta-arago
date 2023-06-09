# Recipe created by recipetool
SUMMARY = "TSN based YANG models"
DESCRIPTION = ""
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://README.md;md5=a89040f014c0c9c9360e29ddf88bf4a7"

SRC_URI = "git://github.com/YangModels/yang.git;protocol=https;branch=main"

PV = "1.0+git${SRCPV}"
SRCREV = "d3f6ca02ec9ce7c96b55066d209d08adbe851897"

S = "${WORKDIR}/git"

FILES:${PN} += "/usr/share/yang/*"

do_install:append () {
    install -d ${D}/usr/share/yang/modules/netopeer2
    install -o root -g root ${S}/standard/ietf/RFC/iana-if-type.yang ${D}/usr/share/yang/modules/netopeer2/iana-if-type@2017-01-19.yang
    install -o root -g root ${S}/standard/ieee/draft/802.1/Qcw/ieee802-types.yang ${D}/usr/share/yang/modules/netopeer2/ieee802-types@2022-10-31.yang
    install -o root -g root ${S}/standard/ieee/draft/802.1/Qcw/ieee802-dot1q-types.yang ${D}/usr/share/yang/modules/netopeer2/ieee802-dot1q-types@2022-10-31.yang
    install -o root -g root ${S}/standard/ieee/draft/802.1/Qcw/ieee802-dot1q-bridge.yang ${D}//usr/share/yang/modules/netopeer2/ieee802-dot1q-bridge@2022-10-31.yang
    install -o root -g root ${S}/standard/ieee/draft/802.1/Qcw/ieee802-dot1q-sched.yang ${D}//usr/share/yang/modules/netopeer2/ieee802-dot1q-sched@2022-08-18.yang
    install -o root -g root ${S}/standard/ieee/draft/802.1/Qcw/ieee802-dot1q-sched-bridge.yang ${D}//usr/share/yang/modules/netopeer2/ieee802-dot1q-sched-bridge@2022-08-18.yang
}
