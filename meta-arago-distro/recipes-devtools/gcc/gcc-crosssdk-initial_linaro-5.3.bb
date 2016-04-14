require gcc-linaro-common-5.3.inc
require recipes-devtools/gcc/gcc-cross-initial_${PV}.bb
require recipes-devtools/gcc/gcc-crosssdk-initial.inc

EXTRA_OECONF += " --with-native-system-header-dir=${SYSTEMHEADERS} "
