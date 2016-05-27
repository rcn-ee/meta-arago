SUMMARY = "A collection of tools for Python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://MANIFEST.in;md5=d41d8cd98f00b204e9800998ecf8427e"

RDEPENDS_${PN} = " python-decorator \
                   python-appdirs \
                   python-six \
                   python-numpy \
"

SRC_URI[md5sum] = "452dfa3023733a675cc1bee91c536cbd"
SRC_URI[sha256sum] = "8939d4a81e17ca30968126e9614100ab38df926b251b96a0b4736234195cca19"

inherit pypi setuptools

# Standard pypi SRC_URI is not available at this time
SRC_URI = "https://pypi.python.org/packages/1a/1e/ce42d53bad97ad16732c8d9ac1dd6ed22a906ea07f291df5f6f90a6c7a2a/pytools-2016.2.1.tar.gz"
