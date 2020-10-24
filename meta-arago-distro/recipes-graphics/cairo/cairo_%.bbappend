PR_append = ".arago1"

PACKAGECONFIG_append = " ${@bb.utils.contains('MACHINE_FEATURES', 'gpu', 'egl glesv2', '', d)}"
