python split_gstreamer10_packages () {
    def gst_lib_hook(file, pkg, pattern, format, basename):
        pkglist = " lib" + basename + " lib" + basename + "-0"
        d.setVar("DEBIAN_NOAUTONAME_" + pkg, "1")
        d.appendVar("RPROVIDES_" + pkg, pkglist)
        d.appendVar("RREPLACES_" + pkg, pkglist)
        d.appendVar("RCONFLICTS_" + pkg, pkglist)

    gst_libdir = d.expand('${libdir}/gstreamer-${LIBV}')
    postinst = d.getVar('plugin_postinst', True)
    glibdir = d.getVar('libdir', True)

    do_split_packages(d, glibdir, '^lib(.*)\.so\.*', 'lib%s', 'gstreamer %s library', extra_depends='', allow_links=True, hook=gst_lib_hook)
    do_split_packages(d, gst_libdir, 'libgst(.*)\.so$', d.expand('${PN}-%s'), 'GStreamer plugin for %s', postinst=postinst, extra_depends=d.expand('${PN}'))
    do_split_packages(d, gst_libdir, 'libgst(.*)\.la$', d.expand('${PN}-%s-dev'), 'GStreamer plugin for %s (development files)', extra_depends=d.expand('${PN}-dev'))
    do_split_packages(d, gst_libdir, 'libgst(.*)\.a$', d.expand('${PN}-%s-staticdev'), 'GStreamer plugin for %s (static development files)', extra_depends=d.expand('${PN}-staticdev'))
}
