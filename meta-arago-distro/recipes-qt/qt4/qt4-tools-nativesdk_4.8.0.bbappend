PR_append = "-arago1"

# Qt/E from Nokia is dual-licensed (LGPLv2.1 or GPLv3)
# For our distribution purposes we only use LGPLv2.1
LICENSE = "LGPLv2.1"

DEPENDS := "${@oe_filter_out('libx11-nativesdk', '${DEPENDS}', d)}"
