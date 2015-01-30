PR_append = "-arago0"

DEPENDS_remove = "gmp"

EXTRA_OECONF_remove = "--enable-gmp"

EXTRA_OECONF += "--disable-gmp"
