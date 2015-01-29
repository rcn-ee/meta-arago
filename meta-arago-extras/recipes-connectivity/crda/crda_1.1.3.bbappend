SRC_URI = "ftp://www.kernel.org/pub/software/network/crda/${BP}.tar.bz2;name=crda \
           ftp://www.kernel.org/pub/software/network/wireless-regdb/wireless-regdb-2013.01.11.tar.gz;name=bin \
"

SRC_URI[bin.md5sum] = "57f2d4c2cdfa2d20c859bca202dd6ece"
SRC_URI[bin.sha256sum] = "608c2fea6ca840a51bc1a8c35c53ca4c20a78d4f78c3bc7cbdcd53dee0cc0cf8"


do_install() {
    oe_runmake SBINDIR=${sbindir}/ install

    install -d ${D}${libdir}/crda/

    install -m 0644 ${WORKDIR}/wireless-regdb-2013.01.11/regulatory.bin ${D}${libdir}/crda/regulatory.bin
}
