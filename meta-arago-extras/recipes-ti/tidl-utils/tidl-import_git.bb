SUMMARY = "TIDL import tool for conversion of Caffe and TF models into TI custom network format"
DESCRIPTION = "TIDL import tool is using protobuf to read and parse information from external network models \
               This is ARM Linux implementation."

require ./tidl-utils.inc

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://modules/ti_dl/inc/itidl_ti.h;beginline=1;endline=34;md5=cabe1fdaabfa0d85dc5544566b0e2425"

S = "${WORKDIR}/git/src/importTool"

DEPENDS = "protobuf zlib protobuf-native flatbuffers tensorflow-lite flatbuffers-native tensorflow-lite-native"

EXTRA_OEMAKE += "TIARM_TOOLS=${GCC_ARM_NONE_TOOLCHAIN}"
EXTRA_OEMAKE += "XDAIS_PATH=${XDAIS_INSTALL_DIR}"
EXTRA_OEMAKE += "SHOW_COMMANDS=1"
EXTRA_OEMAKE += "CORE=eve"
EXTRA_OEMAKE += "TARGET_BUILD=release"
EXTRA_OEMAKE += "TARGET_PLATFORM=PC"

EXTRA_MAKE_ARGS = "PLATFORM_BUILD=x86 LINUXENV=x86 LINUX_IMPORT_TOOL=64BIT \
                   PROTOBUF_LIB_DIR=${STAGING_DIR_NATIVE}/usr/lib PROTOBUF_INC_DIR=${STAGING_DIR_NATIVE}/usr/include \
                   FLATBUFFERS_INC_DIR=${STAGING_DIR_NATIVE}$/usr/include/flatbuffers \
                   TF_LITE_GENERATED_PATH=${STAGING_DIR_NATIVE}/usr/include/tensorflow/lite/schema"
EXTRA_MAKE_ARGS:class-target = "LINUX_BUILD_TOOLS=${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX} \
                                PROTOBUF_LIB_DIR=${STAGING_LIBDIR} PROTOBUF_INC_DIR=${STAGING_INCDIR} \
                                FLATBUFFERS_INC_DIR=${STAGING_INCDIR}/flatbuffers \
                                TF_LITE_GENERATED_PATH=${STAGING_INCDIR}/tensorflow/lite/schema LINUXENV=oearm"

EXTRA_OEMAKE += "${EXTRA_MAKE_ARGS}"

do_compile() {
    cd ${S}/modules/ti_dl/utils
    ./genProtoSrc.sh
    cd ${S}
    oe_runmake -C modules/ti_dl/utils/tidlModelImport
}

do_install () {
    install -d ${D}${bindir}
    install -m 755 ${S}/modules/ti_dl/utils/tidlModelImport/out/tidl_model_import.out ${D}${bindir}
}

INSANE_SKIP:${PN} = "ldflags"

BBCLASSEXTEND = "native nativesdk"
