PACKAGECONFIG_append = "${@bb.utils.contains("DISTRO_FEATURES", "wayland", " qtwayland", "", d)}"

PACKAGECONFIG[qtwayland] = "-DWITH_QT=ON,-DWITH_QT=OFF,qtwayland,"

inherit cmake_qt5

ALLOW_EMPTY_${PN}-java = "1"
ALLOW_EMPTY_${PN}-locale = "1"
