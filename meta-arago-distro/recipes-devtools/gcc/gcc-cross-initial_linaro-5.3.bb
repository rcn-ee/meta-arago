BASEPV = "5.3"
PV = "linaro-${BASEPV}"
require recipes-devtools/gcc/gcc-cross_${PV}.bb
require recipes-devtools/gcc/gcc-cross-initial.inc
