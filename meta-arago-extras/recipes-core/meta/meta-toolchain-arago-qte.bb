# Qt Embedded toolchain
TOOLCHAIN_HOST_TASK = "nativesdk-packagegroup-arago-qte-toolchain-host packagegroup-arago-cross-canadian-${TRANSLATED_TARGET_ARCH}"
TOOLCHAIN_TARGET_TASK = "packagegroup-arago-qte-toolchain-target"
TOOLCHAIN_OUTPUTNAME = "${SDK_NAME}-${ARMPKGARCH}-${TARGET_OS}-qte-sdk-${SDK_ARCH}"

require meta-toolchain-arago.bb

PR = "r10"

QT_DIR_NAME = "qtopia"

toolchain_create_sdk_env_script_append() {
	echo 'export OE_QMAKE_CFLAGS="$CFLAGS"' >> $script
	echo 'export OE_QMAKE_CXXFLAGS="$CXXFLAGS"' >> $script
	echo 'export OE_QMAKE_LDFLAGS="$LDFLAGS"' >> $script
	echo 'export OE_QMAKE_CC=$CC' >> $script
	echo 'export OE_QMAKE_CXX=$CXX' >> $script
	echo 'export OE_QMAKE_LINK=$CXX' >> $script
	echo 'export OE_QMAKE_AR=$AR' >> $script
	echo 'export OE_QMAKE_LIBDIR_QT=$SDK_PATH/$TARGET_SYS${libdir}' >> $script
	echo 'export OE_QMAKE_INCDIR_QT=$SDK_PATH/$TARGET_SYS${includedir}/${QT_DIR_NAME}' >> $script
	echo 'export OE_QMAKE_MOC=$SDK_PATH${bindir_nativesdk}/moc4' >> $script
	echo 'export OE_QMAKE_UIC=$SDK_PATH${bindir_nativesdk}/uic4' >> $script
	echo 'export OE_QMAKE_UIC3=$SDK_PATH${bindir_nativesdk}/uic34' >> $script
	echo 'export OE_QMAKE_RCC=$SDK_PATH${bindir_nativesdk}/rcc4' >> $script
	echo 'export OE_QMAKE_QDBUSCPP2XML=$SDK_PATH${bindir_nativesdk}/qdbuscpp2xml4' >> $script
	echo 'export OE_QMAKE_QDBUSXML2CPP=$SDK_PATH${bindir_nativesdk}/qdbusxml2cpp4' >> $script
	echo 'export OE_QMAKE_QT_CONFIG=$SDK_PATH/$TARGET_SYS${datadir}/${QT_DIR_NAME}/mkspecs/qconfig.pri' >> $script
	echo 'export QMAKESPEC=$SDK_PATH/$TARGET_SYS${datadir}/${QT_DIR_NAME}/mkspecs/linux-g++' >> $script

	#Adds qt.conf file that points qmake to properly locate Qt library and header files.
	#This enables Qt Creator to work properly

	qt_conf="${SDK_OUTPUT}/${SDKPATH}/bin/qt.conf"
	touch $qt_conf
	echo '[Paths]' >> $qt_conf
	echo 'Prefix = $(SDK_PATH)' >> $qt_conf
	echo 'Libraries = $(OE_QMAKE_LIBDIR_QT)' >> $qt_conf
	echo 'Headers = $(OE_QMAKE_INCDIR_QT)' >> $qt_conf

	# make a symbolic link to mkspecs for compatibility with Nokia's SDK
	# and QTCreator
	(cd ${SDK_OUTPUT}/${SDKPATH}; ln -sf ${ARAGO_TARGET_SYS}${datadir}/${QT_DIR_NAME}/mkspecs mkspecs;)
}
