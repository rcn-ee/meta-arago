# The master branch is now 3.2+ kernels.
# This recipe is meant to use the v3.2 that supports 3.2 and older kernels.

require recipes-devtools/ltp-ddt/ltp-ddt_0.0.4.bb

PROVIDES += "ltp-ddt"
RPROVIDES_${PN} += "ltp-ddt"
RREPLACES_${PN} += "ltp-ddt"
RCONFLICTS_${PN} += "ltp-ddt"

PR := "${PR}.0"

SRCREV = "1973c7e79f2ad1b595d5d1687db828f3f3998387"
BRANCH = "v3.2"
