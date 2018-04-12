PR_append = ".arago0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
      file://0001-wayland-drm-Add-wayland-drm-protocol-to-stable.patch \
      "

do_install_append() {
	install -d ${D}${datadir}/wayland-protocols/stable/wayland-drm
	cp ${S}/stable/wayland-drm/wayland-drm.xml ${D}${datadir}/wayland-protocols/stable/wayland-drm/
}
