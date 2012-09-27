DESCRIPTION = "A Python crypto and SSL toolkit"
SECTION = "devel/python"
HOMEPAGE = "http://chandlerproject.org/bin/view/Projects/MeTooCrypto"
PRIORITY = "optional"
DEPENDS = "openssl swig-native"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENCE;md5=8064d5f6760668814ca309788894e713"

SRCNAME = "M2Crypto"
PR = "r0"

SRC_URI = "\
  http://pypi.python.org/packages/source/M/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
  file://install.patch \
  file://m2crypto-0.20.2-openssl-1.0.0.patch;striplevel=0 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

export STAGING_DIR
export STAGING_INCDIR
export STAGING_LIBDIR

SRC_URI[md5sum] = "f93d8462ff7646397a9f77a2fe602d17"
SRC_URI[sha256sum] = "25b94498505c2d800ee465db0cc1aff097b1615adc3ac042a1c85ceca264fc0a"

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
