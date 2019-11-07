DESCRIPTION = "Point cloud viewer"
HOMEPAGE = "https://git.ti.com/processor-sdk/point-cloud-viewer/"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM := "file://PointCloudViewer_manifest.html;md5=7ea694db2dd8d82fd91a18cab8c2c2db"

PR = "r2"

COMPATIBLE_MACHINE = "dra7xx"

BRANCH = "master"

SRC_URI = "git://git.ti.com/processor-sdk/point-cloud-viewer.git;protocol=git;branch=${BRANCH}"

SRCREV = "f0af54e63a6c802b4f8f0657873e74f1cb486e86"

PV = "2.2"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "opencv libxkbcommon"

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
