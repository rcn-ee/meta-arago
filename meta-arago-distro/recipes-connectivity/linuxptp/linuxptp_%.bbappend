PR_append = ".arago0"
PV_append = "+git${SRCPV}"

BRANCH = "ti-linuxptp"
SRCREV = "e54ee647f1d2844b7015d1ae60eef21aa92e113b"

SRC_URI = " \
    git://git.ti.com/processor-sdk/linuxptp.git;branch=${BRANCH} \
    file://build-Allow-CC-and-prefix-to-be-overriden.patch \
    file://no-incdefs-using-host-headers.patch \
"

S = "${WORKDIR}/git"

do_install_append () {
    install -p ${S}/phc2pwm ${D}/${bindir}
}
