PV = "3_1_0_0"
INC_PR = "r4"

require recipes-ti/includes/arago-paths.inc


FFTLIB_GIT_URI = "git://git.ti.com/fftlib/fftlib"
FFTLIB_GIT_PROTOCOL = "git"
FFTLIB_GIT_BRANCH = "master"
FFTLIB_GIT_DESTSUFFIX = "${WORKDIR}/git"

FFTLIB_SRCREV = "e05426894c73af940ccc26880ebd7f2c9ce21880"

BRANCH = "${FFTLIB_GIT_BRANCH}"
SRC_URI = "${FFTLIB_GIT_URI};destsuffix=${FFTLIB_GIT_DESTSUFFIX};protocol=${FFTLIB_GIT_PROTOCOL};branch=${BRANCH}"

SRCREV = "${FFTLIB_SRCREV}"
