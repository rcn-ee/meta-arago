# look for files in this layer first
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago4"

#            file://0003-Updated-configurability.patch.patch
SRC_URI += "file://psplash-18bpp.patch                      \
            file://psplash-poky-img.h                       \
            file://psplash-bar-img.h                        \
            file://0001-psplash-Add-Arago-custom-color.patch\
"

do_configure:prepend() {
    install -m 0644 ${WORKDIR}/psplash-bar-img.h ${S}/
}
