PKGV = "${EAT_VER_LIBC}"

RDEPENDS_ldd = "bash"
RDEPENDS_tzcode = "bash"

BINV = "${EAT_VER_GCC}"
TARGET_SYS = "${EAT_TARGET_SYS}"

do_install_append() {
	install -d ${D}${bindir}
	install -d ${D}${sbindir}
	install -d ${D}${libdir}/${EAT_TARGET_SYS}/${EAT_VER_GCC}
	install -d ${D}${libdir}/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}

	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/bin/* ${D}${bindir}
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/sbin/* ${D}${sbindir}
	rm -rf ${D}${bindir}/gdbserver
	sed -i -e 's#/arm/tools/gnu/bash/4.2/rhe6-x86_64##' ${D}${bindir}/tzselect
	sed -i -e 's#/arm/tools/gnu/bash/4.2/rhe6-x86_64##' ${D}${bindir}/ldd

	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/lib/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/crt*.o ${D}${libdir}/${EAT_TARGET_SYS}/${EAT_VER_GCC}/
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/lib/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/libgcc* ${D}${libdir}/${EAT_TARGET_SYS}/${EAT_VER_GCC}/
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/lib/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/libgcov* ${D}${libdir}/${EAT_TARGET_SYS}/${EAT_VER_GCC}/

	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/lib/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/include ${D}${libdir}/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/lib/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/finclude ${D}${libdir}/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/lib/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/libgfortranbegin.* ${D}${libdir}/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/ || true
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/lib/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/libcaf_single* ${D}${libdir}/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/
}
