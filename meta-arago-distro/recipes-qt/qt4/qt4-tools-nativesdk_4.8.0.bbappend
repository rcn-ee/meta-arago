PR_append = "-arago0"

DEPENDS := "${@oe_filter_out('libx11-nativesdk', '${DEPENDS}', d)}"
