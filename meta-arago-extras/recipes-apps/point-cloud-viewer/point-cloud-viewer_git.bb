DESCRIPTION = "Point cloud viewer"
HOMEPAGE = "https://git.ti.com/processor-sdk/point-cloud-viewer/"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM := "file://PointCloudViewer_manifest.html;md5=7ea694db2dd8d82fd91a18cab8c2c2db"

PR = "r1"

COMPATIBLE_MACHINE = "dra7xx"

BRANCH = "master"

SRC_URI = "git://git.ti.com/processor-sdk/point-cloud-viewer.git;protocol=git;branch=${BRANCH}"

SRCREV = "ac8f7a8334b6458676810349ab84f718ecd16975"

PV = "2.0"

S = "${WORKDIR}/git"

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
