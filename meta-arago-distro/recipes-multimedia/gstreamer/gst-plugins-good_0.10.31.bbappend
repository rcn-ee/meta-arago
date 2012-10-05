PR_append = "-arago0"

# The below changes are meant to mimic the patch
# "gst-plugins-good: disable (uninstalled) examples" commit
# eef5cca4f364545759d8cf624f38e3cd6e8fd295 The patch mentioned above has
# already been applied to master and has been requested to be pulled into
# denzil. The below changes can be removed once that patch has been applied
# to the denzil branch

DEPENDS := "${@oe_filter_out('gtk+','${DEPENDS}', d)}"

EXTRA_OECONF += "--disable-examples"
