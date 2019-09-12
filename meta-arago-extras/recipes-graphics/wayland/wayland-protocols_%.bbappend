PR_append = ".arago1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
      file://0001-wayland-drm-Add-wayland-drm-protocol-to-stable.patch \
      "

SRC_URI_append_j7-evm = "file://0002-wayland-drm-Update-to-version-2.patch"

do_install_append() {
	install -d ${D}${datadir}/wayland-protocols/stable/wayland-drm
	cp ${S}/stable/wayland-drm/wayland-drm.xml ${D}${datadir}/wayland-protocols/stable/wayland-drm/
}
