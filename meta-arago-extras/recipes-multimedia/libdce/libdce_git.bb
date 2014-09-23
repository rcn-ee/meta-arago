DESCRIPTION = "Library used for remotely invoking the hw accelerated codec on IVA-HD"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://libdce.h;beginline=1;endline=31;md5=0a398cf815b8b5f31f552266cd453dae"

inherit autotools pkgconfig

PR = "r1+gitr${SRCPV}"
PV = "2.0"

DEPENDS = "libdrm ti-ipc"

SRC_URI = "git://git.omapzoom.org/repo/libdce.git;protocol=git"
SRCREV = "1916cfef94c4ee41c2beedc9cd87b8916ad29895"

S = "${WORKDIR}/git"
EXTRA_OECONF += "IPC_HEADERS=${STAGING_INCDIR}/ti/ipc/mm"
