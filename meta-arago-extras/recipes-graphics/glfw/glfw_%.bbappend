# Add some wayland configuration options until meta-oe adds some good
# PACKAGECONFIGS

PR:append = ".arago1"

PACKAGECONFIG[wayland] = "-DGLFW_USE_WAYLAND=ON,,wayland wayland-native wayland-protocols extra-cmake-modules libxkbcommon"

PACKAGECONFIG += " wayland"
