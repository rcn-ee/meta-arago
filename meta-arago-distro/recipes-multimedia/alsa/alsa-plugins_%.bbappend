PR_append = ".arago0"

do_install_append() {
	# We don't want pulse to be the default audio device, even when installed
	if [ "${@bb.utils.contains('PACKAGECONFIG', 'pulseaudio', 'yes', 'no', d)}" = "yes" ]; then
		mv ${D}${datadir}/alsa/alsa.conf.d/99-pulseaudio-default.conf ${D}${datadir}/alsa/alsa.conf.d/99-pulseaudio-default.conf.example || true
	fi
}

FILES_${PN}-pulseaudio-conf += "\
	${datadir}/alsa/alsa.conf.d/99-pulseaudio-default.conf.example \
"
