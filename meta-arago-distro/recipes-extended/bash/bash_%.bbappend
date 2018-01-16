PR_append = ".arago0"

EXTRA_OECONF += " --disable-command-timing"

DEPENDS_append_libc-glibc = " virtual/libc-locale"
DEPENDS_remove = "glibc-locale"
