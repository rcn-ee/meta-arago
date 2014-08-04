# This fixes an issue with touchscreens not being detected with the default
# local.rules.  This can be removed when this change is picked up and
# meta-arago switches to Dora

# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

INITSCRIPT_PARAMS_udev = "start 04 S ."

PR_append = "-arago3"
