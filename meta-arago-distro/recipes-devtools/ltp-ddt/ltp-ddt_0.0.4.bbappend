PR_append = "-arago5+gitr${SRCPV}"

RDEPENDS_${PN} += "linaro-pm-qa-utils"

# Commit corresponds to ti2013.12.00 release
SRCREV = "02b425d2618b657748452a87d67b84b792760869"

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
