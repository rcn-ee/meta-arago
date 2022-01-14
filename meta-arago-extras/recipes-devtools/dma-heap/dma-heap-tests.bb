SUMMARY = "Test cases for DMA-Heap framework"
HOMEPAGE = "https://github.com/glneo/dma-heap-tests"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://src/heap_test_fixture.cpp;beginline=1;endline=15;md5=d16465a9e7dc8f53bfdf997c4bf55540"

PV = "1.0"

BRANCH = "master"
SRC_URI = "git://github.com/glneo/dma-heap-tests.git;protocol=https;branch=${BRANCH} \
	file://0001-Variable-name-change-to-fix-compile-error.patch \
"
SRCREV = "bccbfbf24baccefa09439a924f61f04e82b3910a"

DEPENDS = "googletest"

S = "${WORKDIR}/git"

inherit cmake pkgconfig
