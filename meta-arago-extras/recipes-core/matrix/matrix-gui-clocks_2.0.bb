DESCRIPTION = "Clock setting descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

inherit allarch

S = "${WORKDIR}/git/clocks_apps"

# Break out the individual files into separate packages.  That way only the
# clocks supported for each device can be installed.  Prepend the list so
# that we can get the files in ${bindir} first
PACKAGES = "${PN}-275mhz ${PN}-300mhz ${PN}-500mhz ${PN}-600mhz ${PN}-720mhz ${PN}-800mhz ${PN}-1ghz"

# Make sure power submenu and app images has been installed
CLOCK_RDEPENDS = "matrix-gui-apps-images matrix-gui-submenus-power matrix-gui-generic-pm"

RDEPENDS_${PN}-275mhz += "${CLOCK_RDEPENDS}"
RDEPENDS_${PN}-300mhz += "${CLOCK_RDEPENDS}"
RDEPENDS_${PN}-500mhz += "${CLOCK_RDEPENDS}"
RDEPENDS_${PN}-600mhz += "${CLOCK_RDEPENDS}"
RDEPENDS_${PN}-720mhz += "${CLOCK_RDEPENDS}"
RDEPENDS_${PN}-800mhz += "${CLOCK_RDEPENDS}"
RDEPENDS_${PN}-1ghz += "${CLOCK_RDEPENDS}"

# Split the matrix files by clock
FILES_${PN}-275mhz += "${MATRIX_APP_DIR}/power_set_275mhz/*"
FILES_${PN}-300mhz += "${MATRIX_APP_DIR}/power_set_300mhz/*"
FILES_${PN}-500mhz += "${MATRIX_APP_DIR}/power_set_500mhz/*"
FILES_${PN}-600mhz += "${MATRIX_APP_DIR}/power_set_600mhz/*"
FILES_${PN}-720mhz += "${MATRIX_APP_DIR}/power_set_720mhz/*"
FILES_${PN}-800mhz += "${MATRIX_APP_DIR}/power_set_800mhz/*"
FILES_${PN}-1ghz += "${MATRIX_APP_DIR}/power_set_1ghz/*"

# Split the ${bindir} files by clock
FILES_${PN}-275mhz += "${bindir}/setclock275MHz.sh"
FILES_${PN}-300mhz += "${bindir}/setclock300MHz.sh"
FILES_${PN}-500mhz += "${bindir}/setclock500MHz.sh"
FILES_${PN}-600mhz += "${bindir}/setclock600MHz.sh"
FILES_${PN}-720mhz += "${bindir}/setclock720MHz.sh"
FILES_${PN}-800mhz += "${bindir}/setclock800MHz.sh"
FILES_${PN}-1ghz += "${bindir}/setclock1GHz.sh"
