SUMMARY = "OpenCL Integration for Python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2379446cdcffbf1c63a87311b816a656"

DEPENDS = " python-cffi-native python-numpy-native opencl"
RDEPENDS_${PN} = " opencl-runtime \
                   python-numpy \
                   python-pytest \
                   python-pytools \
                   python-decorator \
                   python-cffi \
                   python-appdirs \
                   python-six \
                   python-mako \
"

SRC_URI[md5sum] = "0c8a33b6a6b427bcd9c5966da461d9c6"
SRC_URI[sha256sum] = "54b6e8ad02dc437807739bd53e43851efe979bd51ec87996e44b94ab67238297"

inherit pypi setuptools

# Standard pypi SRC_URI is not available at this time
SRC_URI = "https://pypi.python.org/packages/cb/4e/fcb45db7d3005f5646f28a3de2a2f8e60a6e4b629f02bbb331320778f3a1/pyopencl-2016.1.tar.gz"
