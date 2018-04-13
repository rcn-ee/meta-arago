DESCRIPTION = "Point cloud viewer"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_multimedia"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM := "file://PointCloudViewer_manifest.html;md5=7ea694db2dd8d82fd91a18cab8c2c2db"

PR = "r0"

COMPATIBLE_MACHINE = "dra7xx"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/1304/7978/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "b4a49f1998397efb7c33299a7aeec386"
SRC_URI[sha256sum] = "7b25a185122ed739eab040b77f101f866d33f77c4f64cae95d60213787228f17"

S = "${WORKDIR}/${PN}-${PV}"

RDEPENDS_${PN} = "glfw opencv"

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${S}/point_cloud_viewer ${D}${bindir}

    install -d ${D}${datadir}/ti/pointclouds
    install -m 644 ${S}/example_point_cloud.xyz ${D}${datadir}/ti/pointclouds
}

FILES_${PN} += "\
    ${datadir}/ti/pointclouds \
"

INSANE_SKIP_${PN} = "already-stripped"
