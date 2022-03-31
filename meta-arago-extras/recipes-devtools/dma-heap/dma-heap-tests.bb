SUMMARY = "Test cases for DMA-Heap framework"
HOMEPAGE = "https://github.com/glneo/dma-heap-tests"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://src/heap_test_fixture.cpp;beginline=1;endline=15;md5=d16465a9e7dc8f53bfdf997c4bf55540"

PV = "1.0"

BRANCH = "master"
SRC_URI = "git://github.com/glneo/dma-heap-tests.git;protocol=https;branch=${BRANCH}"
SRCREV = "334fc8ec8056badc9c6667e6f1328705cb973ab4"

DEPENDS = "googletest"

S = "${WORKDIR}/git"

inherit cmake pkgconfig
