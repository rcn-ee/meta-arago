TOOLCHAIN_HOST_TASK ?= "task-arago-sdk-host-nativesdk task-arago-cross-canadian-${TRANSLATED_TARGET_ARCH}"
TOOLCHAIN_TARGET_TASK ?= "task-core-standalone-sdk-target"
TOOLCHAIN_OUTPUTNAME ?= "${SDK_NAME}-${ARMPKGARCH}-${TARGET_OS}-sdk-${SDK_ARCH}"

require recipes-core/meta/meta-toolchain.bb

PR = "r9"

SDKTARGETSYSROOT = "${SDKPATH}/${ARAGO_TARGET_SYS}"

# This function creates an environment-setup-script for use in a deployable SDK
toolchain_create_sdk_env_script () {
	# Create environment setup script
	script=${SDK_OUTPUT}/${SDKPATH}/environment-setup
	rm -f $script
	touch $script
	echo 'SDK_PATH="${SDKPATHNATIVE}"' >> $script
	echo 'if [ -z "$ZSH_NAME" ] && [ "x$0" = "x./environment-setup" ]; then' >> $script
	echo '    echo "Error: This script needs to be sourced. Please run as \". ./environment-setup\""' >> $script
	echo '    exit 1' >> $script
	echo 'else' >> $script
	echo '    if [ -n "$BASH_SOURCE" ]; then' >> $script
	echo '        SDK_PATH="`dirname $BASH_SOURCE`"' >> $script
	echo '    fi' >> $script
	echo '    SDK_PATH=`readlink -f "$SDK_PATH"`' >> $script
	echo '    export SDK_PATH' >> $script
	echo 'fi' >> $script
	echo 'export TARGET_SYS=${ARAGO_TARGET_SYS}' >> $script
	echo 'export TARGET_PREFIX=$TARGET_SYS-' >> $script
	echo 'export PATH=$SDK_PATH/bin:$PATH' >> $script
	echo 'export CPATH=$SDK_PATH/$TARGET_SYS/usr/include:$CPATH' >> $script
	echo 'export PKG_CONFIG_SYSROOT_DIR=$SDK_PATH/$TARGET_SYS' >> $script
	echo 'export PKG_CONFIG_PATH=$SDK_PATH/$TARGET_SYS${libdir}/pkgconfig' >> $script
	echo 'export PKG_CONFIG_ALLOW_SYSTEM_LIBS=1' >> $script
	echo 'export CONFIG_SITE=$SDK_PATH/site-config' >> $script
	printf 'export CC=\x24{TARGET_PREFIX}gcc\n' >> $script
	printf 'export CXX=\x24{TARGET_PREFIX}g++\n' >> $script
	printf 'export GDB=\x24{TARGET_PREFIX}gdb\n' >> $script
	printf 'export CPP="\x24{TARGET_PREFIX}gcc -E"\n' >> $script
	printf 'export NM=\x24{TARGET_PREFIX}nm\n' >> $script
	printf 'export AS=\x24{TARGET_PREFIX}as\n' >> $script
	printf 'export AR=\x24{TARGET_PREFIX}ar\n' >> $script
	printf 'export RANLIB=\x24{TARGET_PREFIX}ranlib\n' >> $script
	printf 'export OBJCOPY=\x24{TARGET_PREFIX}objcopy\n' >> $script
	printf 'export OBJDUMP=\x24{TARGET_PREFIX}objdump\n' >> $script
	printf 'export STRIP=\x24{TARGET_PREFIX}strip\n' >> $script
	echo 'export CONFIGURE_FLAGS="--target=$TARGET_SYS --host=$TARGET_SYS --build=${SDK_ARCH}-linux --with-libtool-sysroot=$SDK_PATH/$TARGET_SYS"' >> $script
	echo 'export CPPFLAGS="${TARGET_CC_ARCH} --sysroot=$SDK_PATH/$TARGET_SYS"' >> $script
	echo 'export CFLAGS="$CPPFLAGS"' >> $script
	echo 'export CXXFLAGS="$CPPFLAGS"' >> $script
	echo 'export LDFLAGS="${TARGET_LD_ARCH} --sysroot=$SDK_PATH/$TARGET_SYS"' >> $script
	echo 'export OECORE_NATIVE_SYSROOT=$SDK_PATH' >> $script
	echo 'export OECORE_TARGET_SYSROOT=$SDK_PATH/$TARGET_SYS' >> $script
	echo 'export OECORE_ACLOCAL_OPTS="-I $SDK_PATH/usr/share/aclocal"' >> $script
	echo 'export OECORE_DISTRO_VERSION="${DISTRO_VERSION}"' >> $script
	echo 'export OECORE_SDK_VERSION="${SDK_VERSION}"' >> $script
	echo 'export PYTHONHOME=$SDK_PATH' >> $script
	echo 'export PYTHONPATH=lib/python2.7' >> $script
}

create_gdb_stub () {
	# Special case for gdb, that is built as part of canadian-cross-sdk
	mv ${ARAGO_TARGET_SYS}-gdb ${ARAGO_TARGET_SYS}-gdb.real
	printf "#!/bin/sh\nif [ -n \x22\x24BASH_SOURCE\x22 ]; then\n\t. \x60dirname \x24BASH_SOURCE\x60/../environment-setup\nfi\n" > ${ARAGO_TARGET_SYS}-gdb
	printf "LD_LIBRARY_PATH=\x24SDK_PATH/lib:\x24LD_LIBRARY_PATH \x24SDK_PATH/lib/ld-linux.so.2 \x24SDK_PATH/bin/${ARAGO_TARGET_SYS}-gdb.real \x24\x2a\n" >> ${ARAGO_TARGET_SYS}-gdb
	chmod +x ${ARAGO_TARGET_SYS}-gdb
}

populate_sdk_ipk_append () {
	cd ${SDK_OUTPUT}/${SDKPATH}/bin
	binfiles=`find ! -name "${ARAGO_TARGET_SYS}-*" -type f -perm +111 -exec file {} \;|grep -v ":.*ASCII.*text"|cut -d":" -f1|cut -c3-`
	for i in $binfiles; do
		mv $i $i.real
		printf "#!/bin/sh\nif [ -n \x22\x24BASH_SOURCE\x22 ]; then\n\t. \x60dirname \x24BASH_SOURCE\x60/../environment-setup\nfi\n" > $i
		printf "LD_LIBRARY_PATH=\x24SDK_PATH/lib:\x24LD_LIBRARY_PATH \x24SDK_PATH/lib/ld-linux.so.2 \x24SDK_PATH/bin/$i.real \x24\x2a\n" >> $i
		chmod +x $i
	done

	${@base_conditional('PREFERRED_PROVIDER_gdb-cross-canadian-arm', 'external-arago-sdk-toolchain', '', 'create_gdb_stub', d)}
}
