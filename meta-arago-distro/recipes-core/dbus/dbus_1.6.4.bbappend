PR_append = "-arago1"

LICENSE = "GPLv2+"

DEPENDS_virtclass-nativesdk := "${@oe_filter_out('virtual/libx11', '${DEPENDS_virtclass-nativesdk}', d)}"
