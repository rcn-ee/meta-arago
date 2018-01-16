FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

OZONE_WAYLAND_EXTRA_PATCHES = " \
	file://0001-wayland.gyp-adjust-Mesa-version-to-work-with-TI-SGX-.patch \
	file://0001-libva-adjust-paths-in-headers-to-include-libva-prefi.patch \
"

USEGOLD = ""

DEPENDS += "gperf-native bison-native"
