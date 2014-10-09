DESCRIPTION = "Scripts and configuration files for TI wireless drivers"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=21;md5=b8d6a0865f50159bf5c0d175d1f4a705"

PR ="r4+gitr${SRCPV}"

# Tag: ol_r8.a9.14
SRCREV = "f6c66162e75c6a31fa7142530534e4df8f1a7bed"
BRANCH = "sitara-mbss"
SRC_URI = "git://git.ti.com/wilink8-wlan/wl18xx-target-scripts.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/wl18xx/"

do_install() {
	install -d ${D}${datadir}/wl18xx/

	scripts=`find ./ -type f -name "*.*"`
	for s in $scripts
	do
		install -m 0755 $s ${D}${datadir}/wl18xx/
	done
}

