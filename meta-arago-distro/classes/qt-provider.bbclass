# Class to handle switching between Qt4 and Qt5
# Usage:
# 1. Set QT_PROVIDER in distro config to either "qt4e" or "qt5"
#    It defaults to "qt4e" when not set
#    Hasn't been tested with "qt4x11" but should theoretically work
# 2. Update recipes to inherit qt-provider instead of qt4e directly
# 3. May need to use below QT_DEPENDS_* and QT_RDEPENDS_* variables
#    instead of the actual Qt-version specific values

QT_PROVIDER ?= "qt4e"

inherit ${QT_PROVIDER}

# Build-time dependencies
QT_DEPENDS_BASE = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtbase', 'qt4-embedded', d)}"
QT_DEPENDS_WEBKIT = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtwebkit', '', d)}"

# Run-time dependencies
QT_RDEPENDS_FONTS = "${@base_conditional('QT_PROVIDER', 'qt5', 'qtbase-fonts', 'qt4-embedded-fonts', d)}"
