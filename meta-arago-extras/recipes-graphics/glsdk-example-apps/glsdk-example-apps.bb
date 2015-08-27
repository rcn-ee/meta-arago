SUMMARY = "GLSDK example applications"
HOMEPAGE = "http://git.ti.com/glsdk"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=10a9abb9c5bb19edd83a8cf66eef7148"

DEPENDS = "${@base_conditional('GST_PROVIDER', '0.10', 'gstreamer', 'gstreamer1.0', d)} libdrm ti-ipc"

COMPATIBLE_MACHINE = "dra7xx"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

SRC_URI = "git://git.ti.com/glsdk/example-applications.git;protocol=git"
SRCREV = "85006e48fbf6e7664699a8d0944013e1f80e8e73"

PR = "r12"
