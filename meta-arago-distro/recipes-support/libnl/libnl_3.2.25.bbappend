PR_append = "-arago0"

do_install_append() {
#   Install private files to allow libnl extensions
    install -d ${D}${includedir}/netlink-private
    cp -r ${S}/include/netlink-private/cache-api.h ${D}${includedir}/netlink-private/
    cp -r ${S}/include/netlink-private/object-api.h ${D}${includedir}/netlink-private/
}
