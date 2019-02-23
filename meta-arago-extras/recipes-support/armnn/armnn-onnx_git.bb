SUMMARY = "Onnx protobuf files - used in ARMNN for Onnx network models"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://onnxImport/LICENSE;md5=077ce3eaeaea91462d41c566300d2a02"

SRC_URI = " \
    git://git.ti.com/tidl/tidl-utils;branch=${BRANCH} \
"

PV = "1.0"

BRANCH = "master"
SRCREV = "af39cf346f602bd2aa75db1e9b31636b78d4e31b"

S = "${WORKDIR}/git"

do_install() {
        install -d ${D}${datadir}/${BPN}/onnx/
        for file in ${S}/onnxImport/*
        do
            install -m 0644 $file ${D}${datadir}/${BPN}/onnx/
        done
}
