SUMMARY = "Onnx protobuf files - used in ARMNN for Onnx network models"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://onnxImport/LICENSE;md5=077ce3eaeaea91462d41c566300d2a02"

SRC_URI  = "git://git.ti.com/tidl/tidl-utils;branch=${BRANCH} \
           "

SRCREV = "0c52c82a2aed1a27ca2a9b4b11effb426842b6ab"

PV = "1.0"

BRANCH = "master"

S = "${WORKDIR}/git"

do_install() {
        install -d ${D}${datadir}/${BPN}/onnx/
        for file in ${S}/onnxImport/ver361/*
        do
            install -m 0644 $file ${D}${datadir}/${BPN}/onnx/
        done
}
