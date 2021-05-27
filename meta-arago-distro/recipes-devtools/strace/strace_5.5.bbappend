
PV = "5.10"
PR = "arago0"

SRC_URI[sha256sum] = "fe3982ea4cd9aeb3b4ba35f6279f0b577a37175d3282be24b9a5537b56b8f01c"
SRC_URI[md5sum] = "5f9f87f9afa282e7512f67a129287d6c"

EXTRA_OECONF += "--disable-gcc-Werror"

RDEPENDS_${PN}-ptest_append_libc-glibc = "\
     locale-base-en-us.iso-8859-1 \
"
