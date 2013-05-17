PR_append = "-arago2+gitr${SRCPV}"

# Auto rev so we pick up the latest changes
SRCREV = "${AUTOREV}"

FILES_${PN}-dbg += " \
	${LTPROOT}/testcases/realtime/*/*/.debug \
"

do_compile_kmodules() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake modules
}

addtask compile_kmodules after do_compile before do_install

# Grab a portion of the module.bbclass to provide the needed kernel application
# scripts/basic/fixdep. This issue is discussed in the following thread.
# http://lists.linuxtogo.org/pipermail/openembedded-core/2011-July/005536.html

inherit module-base

#
# Ensure the hostprogs are available for module compilation. Modules that
# inherit this recipe and override do_compile() should be sure to call
# do_make_scripts() or ensure the scripts are built independently.
#
do_make_scripts() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake CC="${KERNEL_CC}" LD="${KERNEL_LD}" AR="${KERNEL_AR}" \
	           -C ${STAGING_KERNEL_DIR} scripts
}

addtask make_scripts before do_compile
do_make_scripts[lockfiles] = "${TMPDIR}/kernel-scripts.lock"
do_make_scripts[deptask] = "do_populate_sysroot"
