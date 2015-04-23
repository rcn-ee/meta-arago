DESCRIPTION = "AMSDK multimedia support files"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_multimedia/"
LICENSE = "CC-BY-NC-ND-3.0 & CC-BY-3.0"
SECTION = "multimedia"
LIC_FILES_CHKSUM = "file://Multimedia_Data_Files_Manifest.doc;md5=9254447a504d2179d83a6bc9e2c28142"
PR = "r0"

COMPATIBLE_MACHINE = "(omap3|ti33x|ti43x|omap-a15)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

VIDEO_FILES = "video_480p "

VIDEO_FILES_append_am37x-evm   = "video_vga_r"
VIDEO_FILES_append_beagleboard = "video_vga"
VIDEO_FILES_append_am3517-evm  = "video_wqvga"
VIDEO_FILES_append_ti33x       = "video_wvga \
                                  video_wqvga"
VIDEO_FILES_append_dra7xx      = "video_wvga \
                                  video_1080p \
                                  video_720p \
                                  video_yuv"
 
SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/1271/7720/amsdk-av-files_${PV}.tar.gz;name=avfilestarball"

S = "${WORKDIR}/amsdk-av-files"

do_compile() {
    :
}

do_install() {
    install -d ${D}${datadir}/ti \
       ${D}${datadir}/ti/audio \
       ${D}${datadir}/ti/video
    install -m 0644 ${S}/audio/* ${D}${datadir}/ti/audio/
    for file in ${VIDEO_FILES}; do
	install -m 0644 ${S}/${file}/* ${D}${datadir}/ti/video/
    done
}

FILES_${PN} += "${datadir}/ti/*"

SRC_URI[avfilestarball.md5sum] = "3f930cd873bc55bfd52a09b85f567d0c"
SRC_URI[avfilestarball.sha256sum] = "b389b732df409546c0aba6464a5b0815647d8fa24020c4bede823cbe26337c06"
