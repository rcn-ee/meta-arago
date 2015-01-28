PR_append = "-arago0"

DEPENDS := "${@oe_filter_out('gconf','${DEPENDS}', d)}"
DEPENDS := "${@oe_filter_out('gconf-native','${DEPENDS}', d)}"

EXTRA_OECONF += "--disable-gconftool --disable-gconf"
