DESCRIPTION = "Demo helper scripts for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/scripts"

do_install:append(){
    install -d ${D}${bindir}
    install -m 0755 ${S}/optimize-benchmark.sh ${D}${bindir}/ 
}

FILES:${PN} += "{bindir}/*"
