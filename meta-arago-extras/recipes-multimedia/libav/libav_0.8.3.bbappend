PR_append = "-arago0"

# libvpx currently won't build for arm hardfp
DEPENDS := "${@oe_filter_out('libvpx', '${DEPENDS}', d)}"
