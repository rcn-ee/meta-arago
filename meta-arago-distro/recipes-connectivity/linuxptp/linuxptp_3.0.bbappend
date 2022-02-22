PR:append = ".arago0"
PV = "3.0+git${SRCPV}"

BRANCH = "ti-linuxptp"
SRCREV = "f155c21283a0421f5e1e0b5e850c8a9a71d72453"

SRC_URI = " \
    git://git.ti.com/processor-sdk/linuxptp.git;branch=${BRANCH} \
    file://build-Allow-CC-and-prefix-to-be-overriden.patch \
    file://Use-cross-cpp-in-incdefs.patch \
"

S = "${WORKDIR}/git"

do_install:append () {
    install -p ${S}/phc2pwm ${D}/${bindir}
}
