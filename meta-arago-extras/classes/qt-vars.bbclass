# Class to define many useful variables that differ between Qt4 and Qt5

QT_PROVIDER ?= "qt4e"

# Build-time dependencies - those are now separate modules in Qt5 and
# require separate dependencies, unlike Qt4 that provides everything
# in a single qt4-embedded/qt4-x11 recipe
QT_DEPENDS_BASE = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtbase', 'qt4-embedded', d)}"
QT_DEPENDS_WEBKIT = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtwebkit', '', d)}"
QT_DEPENDS_SVG = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtsvg', '', d)}"
QT_DEPENDS_SCRIPT = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtscript', '', d)}"
QT_DEPENDS_WEBENGINE = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtwebengine', '', d)}"

# Run-time dependencies
QT_RDEPENDS_FONTS = "${@base_conditional('QT_PROVIDER', 'qt5', '', 'qt4-embedded-fonts', d)}"
QT_RDEPENDS_NATIVESDK_TOOLS = "${@base_conditional('QT_PROVIDER', 'qt5', 'nativesdk-qtbase-tools nativesdk-qttools', 'nativesdk-qt4-tools', d)}"
QT_RDEPENDS_MKSPECS = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtbase-mkspecs', 'qt4-embedded-mkspecs', d)}"
