DESCRIPTION = "libinput is a library to handle input devices in Wayland compositors"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/libinput/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=673e626420c7f859fbe2be3a9c13632d"

inherit autotools pkgconfig

DEPENDS = "libevdev udev"

PR = "r0"

BRANCH = "master"
SRCREV = "bb10ec84d3704fc0fb40591bcbffe90f6c77966d"

PV = "0.5.0"

SRC_URI = "git://anongit.freedesktop.org/wayland/libinput;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"


