PRINC := "${@int(PRINC) + 2}"

# Temporarily add this append which incorporates the changes of meta-oe master 
# patch "libjpeg-turbo: Add RPROVIDES to fix errors when rdepending on jpeg"
# commit id 662fd013adcbee8c59f4f475a11911c3267eae90.

RPROVIDES_${PN}  += "jpeg"
RREPLACES_${PN}  += "jpeg"
RCONFLICTS_${PN} += "jpeg"

# Patch to incorporate the below changes will be sent to meta-oe master and
# maintenance branch. When this fix is in the maintenance branch then the
# below changes can be removed.
RPROVIDES_jpeg-tools  += "libjpeg-tools"
RREPLACES_jpeg-tools  += "libjpeg-tools"
RCONFLICTS_jpeg-tools += "libjpeg-tools"
