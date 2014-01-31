# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago1"

# Pre-create /run symlink to point to /var/run at build time
# This normally happens on first boot, but may be too late for automount,
# which tries to create mount-points in /run
# NOTE: This step is not required in Dora and up, due to reverse direction
# of symlinking between /run and /var/run
do_install_append () {
	ln -sf /var/run ${D}/run
}
