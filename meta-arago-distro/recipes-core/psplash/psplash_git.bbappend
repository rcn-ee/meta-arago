# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago1"

# Update which portion of the psplash.h file to use as a checksum. This tweak
# has already been done in oe-core master
LIC_FILES_CHKSUM = "file://psplash.h;beginline=1;endline=16;md5=840fb2356b10a85bed78dd09dc7745c6"

# Updating to latest version of psplash. This is the version used in oe-core master
SRCREV = "de9979aefbc56af59b4d236a4b63dd19dcdcfb53"

SRC_URI += "file://psplash-18bpp.patch                      \
            file://0003-Updated-configurability.patch.patch \
            file://psplash-poky-img.h                       \
            file://psplash-bar-img.h                        \
"

do_configure_prepend() {
    install -m 0644 ${WORKDIR}/psplash-bar-img.h ${S}/
}
