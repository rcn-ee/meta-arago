PR_append = "-arago0"

# Add large file support and increase allowable FAT partition size.
CFLAGS_append = " -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64"
CFLAGS_append_libc-uclibc = ' ${@base_contains("DISTRO_FEATURES", "largefile", "-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64", "", d)}'
