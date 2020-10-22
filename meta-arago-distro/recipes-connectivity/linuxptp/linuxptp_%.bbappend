PR_append = ".arago0"
PV_append = "+git${SRCPV}"

BRANCH = "ti-linuxptp"
SRCREV = "a06698a12e828a0372955c2d9c8d6604d8326811"

SRC_URI = " \
    git://git.ti.com/processor-sdk/linuxptp.git;branch=${BRANCH} \
    file://build-Allow-CC-and-prefix-to-be-overriden.patch \
    file://no-incdefs-using-host-headers.patch \
"

S = "${WORKDIR}/git"

do_install_append () {
    install -p ${S}/phc2pwm ${D}/${bindir}
}
