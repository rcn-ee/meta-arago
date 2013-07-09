PR_append = "-arago0"

# Removing pulseaudio-module-console-kit which depends on console-kit.
# Console-kit has x11 dependencies which can't be built do to Arago being a non x11 distro.
RDEPENDS_pulseaudio-server := "${@oe_filter_out('pulseaudio-module-console-kit','${RDEPENDS_pulseaudio-server}', d)}"
