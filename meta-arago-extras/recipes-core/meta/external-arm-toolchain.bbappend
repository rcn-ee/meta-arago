ALLOW_EMPTY_ldd = "1"

LIC_FILES_CHKSUM = "\
	file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
	file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420 \
"

PROVIDES += "\
	virtual/libc-locale \
"

do_install() {
	# Add stubs for files OE-core expects
	install -d ${S}/nscd/
	touch  ${S}/nscd/nscd.init
	touch  ${S}/nscd/nscd.conf
	touch  ${S}/nscd/nscd.service
        touch  ${S}/../makedbs.sh 

	install -d ${D}${base_libdir}
	install -d ${D}${bindir}
	install -d ${D}${sbindir}
	install -d ${D}${libdir}
	install -d ${D}${libexecdir}
	install -d ${D}${datadir}
	install -d ${D}${includedir}
	install -d ${D}/include

	CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/${EAT_LIBDIR}/*  ${D}${base_libdir}
	if [ -d ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/${EAT_LIBDIR}/${EAT_TARGET_SYS} ]; then
		cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/${EAT_LIBDIR}/${EAT_TARGET_SYS}/*  ${D}${base_libdir}
	else
		if [ -f ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/${EAT_LIBDIR}/ld-${EAT_VER_LIBC}.so ]; then
			cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/${EAT_LIBDIR}/*  ${D}${base_libdir}
		else
			cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/${EAT_LIBDIR}/*.so*  ${D}${base_libdir}
		fi
	fi
	if [ -d ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/${EAT_LIBDIR}/${EAT_TARGET_SYS} ]; then
		cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/${EAT_LIBDIR}/${EAT_TARGET_SYS}/*  ${D}${libdir}
	else
		cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/${EAT_LIBDIR}/*  ${D}${libdir}
		if [ ! -f ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/${EAT_LIBDIR}/ld-${EAT_VER_LIBC}.so ]; then
			rm -rf ${D}${libdir}/*.so*
		fi
	fi
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/share/*  ${D}${datadir}
	cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/include/*  ${D}${includedir}
	if [ -d ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/include/${EAT_TARGET_SYS} ]; then
		cp ${CP_ARGS} -H ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/libc/usr/include/${EAT_TARGET_SYS}/*  ${D}${includedir}
		rm -r ${D}${includedir}/${EAT_TARGET_SYS}
	fi

	cp -a ${EXTERNAL_TOOLCHAIN}/${EAT_TARGET_SYS}/include/* ${D}${includedir}
	ln -sf ../usr/include/c++ ${D}/include/c++

	# fix up the copied symlinks (they are still pointing to the multiarch directory)
	linker_name="${@bb.utils.contains("TUNE_FEATURES", "aarch64", "ld-linux-aarch64.so.1", bb.utils.contains("TUNE_FEATURES", "callconvention-hard", "ld-linux-armhf.so.3", "ld-linux.so.3",d), d)}"
	ln -sf ld-${EAT_VER_LIBC}.so ${D}${base_libdir}/${linker_name}
	ln -sf ../../lib/librt.so.1 ${D}${libdir}/librt.so
	ln -sf ../../lib/libgcc_s.so.1 ${D}${libdir}/libgcc_s.so
	ln -sf ../../lib/libcrypt.so.1 ${D}${libdir}/libcrypt.so
	ln -sf ../../lib/libresolv.so.2 ${D}${libdir}/libresolv.so
	ln -sf ../../lib/libnss_dns.so.2 ${D}${libdir}/libnss_dns.so
	ln -sf ../../lib/libnss_hesiod.so.2 ${D}${libdir}/libnss_hesiod.so
	ln -sf ../../lib/libutil.so.1 ${D}${libdir}/libutil.so
	ln -sf ../../lib/libnss_files.so.2 ${D}${libdir}/libnss_files.so
	ln -sf ../../lib/libnss_compat.so.2 ${D}${libdir}/libnss_compat.so
	ln -sf ../../lib/libBrokenLocale.so.1 ${D}${libdir}/libBrokenLocale.so
	ln -sf ../../lib/libthread_db.so.1 ${D}${libdir}/libthread_db.so
	ln -sf ../../lib/libpthread.so.0 ${D}${libdir}/libpthread.so
	ln -sf ../../lib/libthread_db.so.1 ${D}${libdir}/libthread_db-1.0.so
	ln -sf ../../lib/libanl.so.1 ${D}${libdir}/libanl.so
	ln -sf ../../lib/libdl.so.2 ${D}${libdir}/libdl.so
	ln -sf ../../lib/libnss_db.so.2 ${D}${libdir}/libnss_db.so
	ln -sf ../../lib/libnss_dns.so.2 ${D}${libdir}/libnss_dns.so
	ln -sf ../../lib/libnss_files.so.2 ${D}${libdir}/libnss_files.so
	ln -sf ../../lib/libnss_compat.so.2 ${D}${libdir}/libnss_compat.so
	ln -sf ../../lib/libm.so.6 ${D}${libdir}/libm.so
	ln -sf ../../lib/libatomic.so.1 ${D}${libdir}/libatomic.so
	ln -sf ../../lib/libgomp.so.1 ${D}${libdir}/libgomp.so
	ln -sf ../../lib/libitm.so.1 ${D}${libdir}/libitm.so
	ln -sf ../../lib/libssp.so.0 ${D}${libdir}/libssp.so
	ln -sf ../../lib/libstdc++.so.6 ${D}${libdir}/libstdc++.so
	ln -sf ../../lib/libubsan.so.1 ${D}${libdir}/libubsan.so
	ln -sf ../../lib/libasan.so.5 ${D}${libdir}/libasan.so
	ln -sf ../../lib/libgfortran.so.5 ${D}${libdir}/libgfortran.so

	# remove potential .so duplicates from base_libdir
	# for all symlinks created above in libdir
	rm -f ${D}${base_libdir}/librt.so
	rm -f ${D}${base_libdir}/libcrypt.so
	rm -f ${D}${base_libdir}/libnss_nis.so
	rm -f ${D}${base_libdir}/libresolv.so
	rm -f ${D}${base_libdir}/libnss_dns.so
	rm -f ${D}${base_libdir}/libnss_hesiod.so
	rm -f ${D}${base_libdir}/libutil.so
	rm -f ${D}${base_libdir}/libnss_files.so
	rm -f ${D}${base_libdir}/libnss_compat.so
	rm -f ${D}${base_libdir}/libBrokenLocale.so
	rm -f ${D}${base_libdir}/libthread_db.so
	rm -f ${D}${base_libdir}/libanl.so
	rm -f ${D}${base_libdir}/libdl.so
	rm -f ${D}${base_libdir}/libnss_nisplus.so
	rm -f ${D}${base_libdir}/libnss_db.so
	rm -f ${D}${base_libdir}/libm.so
	rm -f ${D}${base_libdir}/libasan.so
	rm -f ${D}${base_libdir}/libatomic.so
	rm -f ${D}${base_libdir}/libgomp.so
	rm -f ${D}${base_libdir}/libitm.so
	rm -f ${D}${base_libdir}/libssp.so
	rm -f ${D}${base_libdir}/libstdc++.so
	rm -f ${D}${base_libdir}/libgfortran.so
	rm -f ${D}${base_libdir}/libubsan.so

	# Besides ld-${EAT_VER_LIBC}.so, other libs can have duplicates like lib*-${EAT_VER_LIBC}.so
	# Only remove them if both are regular files and are identical
	for i in ${D}${base_libdir}/lib*-${EAT_VER_LIBC}.so; do
		f=$(echo $i | sed 's/-${EAT_VER_LIBC}//')
		l=$(ls $f.*)
		if [ $(readlink -f $i ) = $l ]; then
			echo "$i is a symlink of $l, keep it"
		elif [ $(readlink -f $l ) = $i ]; then
			echo "$l is a symlink of $i, keep it"
		else
			cmp -s $i $l
			if [ $? -eq 0 ]; then
				echo "$i is a duplicate of $l, remove it"
				rm $i
			else
				echo "$i and $l are different files, keep them both"
			fi
		fi
	done

	if [ -d ${D}${base_libdir}/arm-linux-gnueabi ]; then
	   rm -rf ${D}${base_libdir}/arm-linux-gnueabi
	fi

	if [ -d ${D}${base_libdir}/ldscripts ]; then
	   rm -rf ${D}${base_libdir}/ldscripts
	fi

	# Provided by libnsl2
	rm -rf ${D}${includedir}/rpcsvc/yppasswd.*
	# Provided by quota
	rm -rf ${D}${includedir}/rpcsvc/rquota.*

       if [ -f ${D}${libdir}/libc.so ];then
               sed -i -e "s# /${EAT_LIBDIR}/${EAT_TARGET_SYS}# ../../${EAT_LIBDIR}#g" -e "s# /usr/${EAT_LIBDIR}/# /usr/lib/#g" -e "s# /usr/${EAT_LIBDIR}/${EAT_TARGET_SYS}# .#g" -e "s# /${EAT_LIBDIR}/ld-linux# ../../${EAT_LIBDIR}/ld-linux#g" ${D}${libdir}/libc.so
                sed -i -e "s# /${EAT_LIBDIR}/libc.so.6# /lib/libc.so.6#g" ${D}${libdir}/libc.so
                # cat kjasdkjasd
       fi

	if [ -f ${D}${base_libdir}/libc.so ];then
		sed -i -e "s# /${EAT_LIBDIR}/${EAT_TARGET_SYS}# ../../lib#g" -e "s# /usr/${EAT_LIBDIR}/${EAT_TARGET_SYS}# .#g" "s# /${EAT_LIBDIR}/# /lib/#g" ${D}${base_libdir}/libc.so
		if [ -f ${D}${base_libdir}/libc.so.6 ]; then
			sed -i -e "s# /usr/${EAT_LIBDIR}/libc.so.6# /lib/libc.so.6#g" "s# /${EAT_LIBDIR}/libc.so.6# /lib/libc.so.6#g" ${D}${base_libdir}/libc.so.6
		fi
	fi
	if [ -f ${D}${base_libdir}/libpthread.so.0 ]; then
			sed -i -e "s# /usr/${EAT_LIBDIR}/libpthread.so.0# /lib/libpthread.so.0#g" ${D}${base_libdir}/libpthread.so.0
	fi

	# Remove if empty
	rmdir ${D}${bindir} || true
	rmdir ${D}${sbindir} || true
}

RPROVIDES_${PN}-staticdev = "glibc-staticdev"

FILES_libgcc = " \
    ${base_libdir}/libgcc_s.so.1 \
    ${base_libdir}/libgcc_s.so \
"

FILES_linux-libc-headers = ""
FILES_linux-libc-headers-dev = "\
	${includedir}/asm* \
	${includedir}/linux \
	${includedir}/mtd \
	${includedir}/rdma \
	${includedir}/scsi \
	${includedir}/sound \
	${includedir}/video \
"

FILES_libstdc++ = "${base_libdir}/libstdc++.so.*"
FILES_libstdc++-dev = "\
  /include/c++ \
  ${includedir}/c++/ \
  ${base_libdir}/libstdc++.so \
  ${base_libdir}/libstdc++.la \
  ${base_libdir}/libsupc++.la"
FILES_libstdc++-staticdev = "\
  ${base_libdir}/libstdc++.a \
  ${base_libdir}/libsupc++.a"
FILES_libstdc++-dbg = "\
  ${base_libdir}/debug/libstdc++.*"
