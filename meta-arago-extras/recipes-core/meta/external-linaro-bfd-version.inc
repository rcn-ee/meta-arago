def elt_get_bfd_version(d):
	import subprocess,os,bb
	if os.path.exists(d.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+d.getVar('TARGET_PREFIX', d, 1)+'as'):
		return subprocess.Popen([d.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+d.getVar('TARGET_PREFIX', d, 1)+'as', '-v', '--version'], stderr=subprocess.STDOUT,stdout=subprocess.PIPE).communicate()[0].splitlines()[0].split()[3]

ELT_VER_BFD := "${@elt_get_bfd_version(d)}"
