PRINC := "${@int(PRINC) + 1}"

# Temporarily add this append which incorporates the changes of meta-oe master 
# patch "libjpeg-turbo: Add RPROVIDES to fix errors when rdepending on jpeg"
# commit id 662fd013adcbee8c59f4f475a11911c3267eae90.

RPROVIDES_${PN}  += "jpeg"
RREPLACES_${PN}  += "jpeg"
RCONFLICTS_${PN} += "jpeg"
