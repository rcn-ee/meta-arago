require recipes-kernel/kexec/kexec-tools.inc
export LDFLAGS = "-L${STAGING_LIBDIR}"
EXTRA_OECONF = " --with-zlib=yes"

S = "${WORKDIR}/git"

PV = "2.0.12+2.0.13pre"

BRANCH="master"
SRCREV = "4db7f295d59651ead1f7632198fe8c113a2e8890"

SRC_URI = "git://git.kernel.org/pub/scm/utils/kernel/kexec/kexec-tools.git;protocol=git;branch=${BRANCH}"

SRC_URI += " \
    file://kdump \
    file://kdump.conf \
"

PACKAGES =+ "kexec kdump vmcore-dmesg"

ALLOW_EMPTY_${PN} = "1"
RRECOMMENDS_${PN} = "kexec kdump vmcore-dmesg"

FILES_kexec = "${sbindir}/kexec"
FILES_kdump = "${sbindir}/kdump ${sysconfdir}/init.d/kdump \
               ${sysconfdir}/sysconfig/kdump.conf"
FILES_vmcore-dmesg = "${sbindir}/vmcore-dmesg"

inherit update-rc.d

INITSCRIPT_PACKAGES = "kdump"
INITSCRIPT_NAME_kdump = "kdump"
INITSCRIPT_PARAMS_kdump = "start 56 2 3 4 5 . stop 56 0 1 6 ."

do_install_append () {
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/kdump ${D}${sysconfdir}/init.d/kdump
        install -d ${D}${sysconfdir}/sysconfig
        install -m 0644 ${WORKDIR}/kdump.conf ${D}${sysconfdir}/sysconfig
}
