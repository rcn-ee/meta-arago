PR_append = "-arago0"

FILES_${PN} = "\
  ${bindir}/${TARGET_PREFIX}gcc* \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/collect2 \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/cc* \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/lto* \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/lib*${SOLIBS} \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/liblto*${SOLIBSDEV} \
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/*.o \
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/specs \
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/lib*${SOLIBS} \
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/include \
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/include-fixed \
  ${libexecdir}/gcc/${TARGET_SYS} \
  ${gcclibdir}/${TARGET_SYS} \
"

FILES_${PN}-dbg += "\
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/.debug/ \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/plugin/.debug/ \
"

FILES_${PN}-dev = "\
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/lib*${SOLIBSDEV} \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/lib*${SOLIBSDEV} \
"

FILES_${PN}-plugin-dev = "\
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/plugin/include/ \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/plugin/gengtype \
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/plugin/gtype.state \
"

FILES_${PN}-plugins = "\
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/plugin \
"

FILES_g77 = "\
  ${bindir}/${TARGET_PREFIX}g77 \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/f771 \
"

FILES_gfortran = "\
  ${bindir}/${TARGET_PREFIX}gfortran \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/f951 \
"

FILES_cpp = "\
  ${bindir}/${TARGET_PREFIX}cpp \
  ${base_libdir}/cpp \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/cc1 \
"

FILES_g++ = "\
  ${bindir}/${TARGET_PREFIX}g++ \
  ${libexecdir}/gcc/${ELT_TARGET_SYS}/${BINV}/cc1plus \
"

FILES_${PN}-doc = "\
  ${infodir} \
  ${mandir} \
  ${gcclibdir}/${ELT_TARGET_SYS}/${BINV}/include/README \
"

do_install_append() {
  cd ${D}/${libexecdir}/gcc/
  mv ${TARGET_SYS} ${ELT_TARGET_SYS}
  ln -sf ${ELT_TARGET_SYS} ${TARGET_SYS}
  cd ${D}/${gcclibdir}
  mv ${TARGET_SYS} ${ELT_TARGET_SYS}
  ln -sf ${ELT_TARGET_SYS} ${TARGET_SYS}
}
