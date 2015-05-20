require recipes-kernel/kexec/kexec-tools.inc
export LDFLAGS = "-L${STAGING_LIBDIR}"
EXTRA_OECONF = " --with-zlib=yes"

PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

BRANCH="master"
SRC_URI = "git://git.kernel.org/pub/scm/utils/kernel/kexec/kexec-tools.git;protocol=git;branch=${BRANCH}"
SRC_URI_append_keystone = " file://0001-kexec-ks2-use-KS2-aliased-addresses-on.patch"

SRCREV = "4afd47956f05ec8f71daf688d5d52837d6e40b2c"

PACKAGES =+ "kexec kdump"

FILES_kexec = "${sbindir}/kexec"
FILES_kdump = "${sbindir}/kdump"
