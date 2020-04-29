SUMMARY = "Rpmsg char Helper library recipe"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PROTOCOL = "git"
BRANCH = "master"
SRCREV = "fba8b83ea02d978eefbbd65a885daafa9c93b479"
SRC_URI = "git://git.ti.com/glsdk/rpmsg-char-helper.git;protocol=${PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF_j7-evm += " \
	--with-soc=j7 \
"
