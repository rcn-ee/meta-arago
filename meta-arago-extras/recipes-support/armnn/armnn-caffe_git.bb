SUMMARY = "Caffe protobuf files - used in ARMNN for Caffe network models"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://caffeImport/LICENSE;md5=91d560803ea3d191c457b12834553991"

SRC_URI  = "git://git.ti.com/tidl/tidl-utils;branch=${BRANCH} \
           "

SRCREV = "0c52c82a2aed1a27ca2a9b4b11effb426842b6ab"

PV = "1.0"

BRANCH = "master"

S = "${WORKDIR}/git"

do_install() {
        install -d ${D}${datadir}/${BPN}/caffe/proto/
        for file in ${S}/caffeImport/ver361/*
        do
            install -m 0644 $file ${D}${datadir}/${BPN}/caffe/proto/
        done
}
