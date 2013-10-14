PRINC := "${@int(PRINC) + 4}"

SRC_URI = "svn://libjpeg-turbo.svn.sourceforge.net/svnroot/libjpeg-turbo;protocol=http;module=trunk"

# Patch to incorporate the below changes will be sent to meta-oe master and
# maintenance branch. When this fix is in the maintenance branch then the
# below changes can be removed.
RPROVIDES_jpeg-tools  += "libjpeg-tools"
RREPLACES_jpeg-tools  += "libjpeg-tools"
RCONFLICTS_jpeg-tools += "libjpeg-tools"
