DESCRIPTION = "libevdev is a wrapper library for evdev devices"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/libevdev/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=75aae0d38feea6fda97ca381cb9132eb"

inherit autotools pkgconfig

PR = "r0"

BRANCH = "master"
SRCREV = "a5f150ef57a1a5c67e94163f6f5a60687049413f"
PV = "1.2.99.901"
SRC_URI = "git://anongit.freedesktop.org/libevdev;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"
