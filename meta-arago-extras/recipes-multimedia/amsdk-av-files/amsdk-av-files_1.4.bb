DESCRIPTION = "AMSDK multimedia support files"
HOMEPAGE = "https://git.ti.com/processor-sdk/amsdk-av-files/"
LICENSE = "CC-BY-NC-ND-3.0 & CC-BY-3.0"
SECTION = "multimedia"
LIC_FILES_CHKSUM = "file://Multimedia_Data_Files_Manifest.doc;md5=fe154d291c69c51495a5bb4a456403b5"
PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

VIDEO_FILES = "video_480p "

VIDEO_FILES_append_am37x-evm   = "video_vga_r"
VIDEO_FILES_append_beagleboard = "video_vga"
VIDEO_FILES_append_am3517-evm  = "video_wqvga"
VIDEO_FILES_append_ti33x       = "video_wvga \
                                  video_wqvga"
VIDEO_FILES_append_ti43x       = "video_wqvga"
VIDEO_FILES_append_dra7xx      = "video_wvga \
                                  video_1080p \
                                  video_720p \
                                  video_yuv"
VIDEO_FILES_append_k3          = "video_720p"

VIDEO_FILES_keystone = "video_720p "

BRANCH = "master"

SRC_URI = "git://git.ti.com/processor-sdk/amsdk-av-files.git;protocol=git;branch=${BRANCH}"
SRCREV = "1b73009090265328ebaf1b6c880dfeccae5a8f19"

S = "${WORKDIR}/git"

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

