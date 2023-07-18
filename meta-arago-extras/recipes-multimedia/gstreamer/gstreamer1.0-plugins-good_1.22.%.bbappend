FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-Adding-support-for-raw10-raw12-and-raw16-bayer-formats.patch \
    file://0002-Adding-support-for-bayer-formats-with-IR-component.patch \
"

SRC_URI:append:j721s2 = " \
    file://0001-v4l2-Changes-for-DMA-Buf-import-j721s2.patch \
    file://0002-v4l2-Give-preference-to-contiguous-format-if-support.patch \
"

SRC_URI:append:j784s4 = " \
    file://0001-v4l2-Changes-for-DMA-Buf-import-j721s2.patch \
    file://0002-v4l2-Give-preference-to-contiguous-format-if-support.patch \
"

SRC_URI:append:am62axx = " \
    file://0001-v4l2-Changes-for-DMA-Buf-import-j721s2.patch \
    file://0002-v4l2-Give-preference-to-contiguous-format-if-support.patch \
"

PR:append = ".arago0"
