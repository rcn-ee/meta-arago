PR_append = "-arago0"

# The below changes are meant to mimic the patch
# "gconf: Disable gtk support" commit 6facee8443966b646cd1e72f14ae13e58a13f621
# The patch mentioned above has already been applied to master and has been 
# requested to be pulled into denzil. The below changes can be removed once 
# that patch has been applied to the denzil branch

DEPENDS := "${@oe_filter_out('gtk+','${DEPENDS}', d)}"
EXTRA_OECONF += "--disable-gtk"

# Clear GTKOECONF variable to ensure gconf isn't configured to use gtk
GTKOECONF = ""
GTKOECONF_virtclass-native = ""
