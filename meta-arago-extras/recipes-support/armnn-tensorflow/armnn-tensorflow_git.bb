SUMMARY = "Tensorflow protobuf files - used in ARMNN for Tensorflow network models"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01e86893010a1b87e69a213faa753ebd"

SRC_URI = " \
    git://github.com/tensorflow/tensorflow.git;name=tensorflow; \
    git://github.com/ARM-software/armnn.git;name=armnn;subdir=${WORKDIR}/armnn;destsuffix=armnn \
"

PV = "1.10.0"

SRCREV_tensorflow = "aed8f42bafabf11c5d92ce4109a5e0408b31f9c5"
SRCREV_armnn = "4c7098bfeab1ffe1cdc77f6c15548d3e73274746"
SRCREV_FORMAT = "tensorflow"

DEPENDS = "protobuf-native"

S = "${WORKDIR}/git"

do_install() {
    # Install sources + build artifacts as reuired by ARMNN
    install -d ${D}${datadir}/${BPN}

    # Convert protobuf sources to C sources and install
    ${WORKDIR}/armnn/scripts/generate_tensorflow_protobuf.sh ${D}${datadir}/${BPN} ${STAGING_DIR_NATIVE}${prefix}
}
