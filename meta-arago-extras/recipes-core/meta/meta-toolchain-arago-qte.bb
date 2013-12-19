# Qt Embedded toolchain
TOOLCHAIN_HOST_TASK ?= "nativesdk-packagegroup-arago-qte-toolchain-host"
TOOLCHAIN_TARGET_TASK ?= "${@base_conditional('QT_PROVIDER', 'qt5', 'packagegroup-arago-qt5-toolchain-target', 'packagegroup-arago-qte-toolchain-target', d)}"
TOOLCHAIN_SUFFIX ?= "-qte-sdk"

require meta-toolchain-arago.bb

PR = "r18"

# There could be qt5, qt4e and qt4x11 providers, but we don't support qt4x11 for now
QT_DIR_NAME = "${@base_conditional('QT_PROVIDER', 'qt5', 'qt5', 'qtopia', d)}"
QT_BIN_PREFIX = "${@base_conditional('QT_PROVIDER', 'qt5', "${QT_DIR_NAME}/", '', d)}"
QT_BIN_SUFFIX = "${@base_conditional('QT_PROVIDER', 'qt5', '', '4', d)}"
QT_MKSPECS_LOCATION = "${@base_conditional('QT_PROVIDER', 'qt5', "${libdir}", "${datadir}", d)}"

toolchain_create_sdk_env_script_append() {
	echo 'export PATH=$SDK_PATH_NATIVE${bindir_nativesdk}/${QT_DIR_NAME}:$PATH' >> $script
	echo 'export OE_QMAKE_CFLAGS="$CFLAGS"' >> $script
	echo 'export OE_QMAKE_CXXFLAGS="$CXXFLAGS"' >> $script
	echo 'export OE_QMAKE_LDFLAGS="$LDFLAGS"' >> $script
	echo 'export OE_QMAKE_CC=$CC' >> $script
	echo 'export OE_QMAKE_CXX=$CXX' >> $script
	echo 'export OE_QMAKE_LINK=$CXX' >> $script
	echo 'export OE_QMAKE_AR=$AR' >> $script
	echo 'export OE_QMAKE_LIBDIR_QT=$SDK_PATH_TARGET${libdir}' >> $script
	echo 'export OE_QMAKE_INCDIR_QT=$SDK_PATH_TARGET${includedir}/${QT_DIR_NAME}' >> $script
	echo 'export OE_QMAKE_HOST_BINDIR_QT=$SDK_PATH_NATIVE${bindir_nativesdk}/${QT_BIN_PREFIX}' >> $script
	echo 'export OE_QMAKE_MOC=$SDK_PATH_NATIVE${bindir_nativesdk}/${QT_BIN_PREFIX}moc${QT_BIN_SUFFIX}' >> $script
	echo 'export OE_QMAKE_UIC=$SDK_PATH_NATIVE${bindir_nativesdk}/${QT_BIN_PREFIX}uic${QT_BIN_SUFFIX}' >> $script
	echo 'export OE_QMAKE_UIC3=$SDK_PATH_NATIVE${bindir_nativesdk}/${QT_BIN_PREFIX}uic3${QT_BIN_SUFFIX}' >> $script
	echo 'export OE_QMAKE_RCC=$SDK_PATH_NATIVE${bindir_nativesdk}/${QT_BIN_PREFIX}rcc${QT_BIN_SUFFIX}' >> $script
	echo 'export OE_QMAKE_QDBUSCPP2XML=$SDK_PATH_NATIVE${bindir_nativesdk}/${QT_BIN_PREFIX}qdbuscpp2xml${QT_BIN_SUFFIX}' >> $script
	echo 'export OE_QMAKE_QDBUSXML2CPP=$SDK_PATH_NATIVE${bindir_nativesdk}/${QT_BIN_PREFIX}qdbusxml2cpp${QT_BIN_SUFFIX}' >> $script
	echo 'export OE_QMAKE_QT_CONFIG=$SDK_PATH_TARGET${QT_MKSPECS_LOCATION}/${QT_DIR_NAME}/mkspecs/qconfig.pri' >> $script
	echo 'export OE_QMAKE_STRIP="echo"' >> $script
	echo 'export QMAKESPEC=$SDK_PATH_TARGET${QT_MKSPECS_LOCATION}/${QT_DIR_NAME}/mkspecs/linux-gnueabi-oe-g++' >> $script
	echo 'export QMAKE_DEFAULT_LIBDIRS=${QT_QMAKE_LIBDIR_QT}' >> $script
	echo 'export QMAKE_DEFAULT_INCDIRS=${QT_QMAKE_INCDIR_QT}' >> $script

	#Adds qt.conf file that points qmake to properly locate Qt library and header files.
	#This enables Qt Creator to work properly

	qt_conf="${SDK_OUTPUT}/${SDKPATHNATIVE}${bindir_nativesdk}/${QT_BIN_PREFIX}qt.conf"
	touch $qt_conf
	echo '[Paths]' >> $qt_conf
	echo 'Prefix = $(SDK_PATH_TARGET)' >> $qt_conf
	echo 'Libraries = $(OE_QMAKE_LIBDIR_QT)' >> $qt_conf
	echo 'Headers = $(OE_QMAKE_INCDIR_QT)' >> $qt_conf
	echo 'HostPrefix = $(SDK_PATH_NATIVE)' >> $qt_conf
	echo 'HostBinaries = $(OE_QMAKE_HOST_BINDIR_QT)' >> $qt_conf

	# make a symbolic link to mkspecs for compatibility with Nokia's SDK
	# and QTCreator
	(cd ${SDK_OUTPUT}/${SDKTARGETSYSROOT}; ln -sf .${QT_MKSPECS_LOCATION}/${QT_DIR_NAME}/mkspecs mkspecs;)
}
