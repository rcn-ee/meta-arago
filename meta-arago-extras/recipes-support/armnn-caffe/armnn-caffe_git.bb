SUMMARY = "Caffe protobuf files - used in ARMNN for Caffe network models"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://caffeImport/LICENSE;md5=91d560803ea3d191c457b12834553991"

SRC_URI = " \
    git://git.ti.com/tidl/tidl-utils;branch=${BRANCH} \
"

PV = "1.0"

BRANCH = "master"
SRCREV = "16030b2e43de6143f371072d54760737ddda0645"

S = "${WORKDIR}/git"

do_install() {
        install -d ${D}${datadir}/${BPN}/caffe/proto/
        for file in ${S}/caffeImport/*
        do
            install -m 0644 $file ${D}${datadir}/${BPN}/caffe/proto/
        done
}
