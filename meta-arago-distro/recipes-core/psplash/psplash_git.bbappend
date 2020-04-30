# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago4"

#            file://0003-Updated-configurability.patch.patch
SRC_URI += "file://psplash-18bpp.patch                      \
            file://psplash-poky-img.h                       \
            file://psplash-bar-img.h                        \
            file://0001-psplash-Add-Arago-custom-color.patch\
"

do_configure_prepend() {
    install -m 0644 ${WORKDIR}/psplash-bar-img.h ${S}/
}
