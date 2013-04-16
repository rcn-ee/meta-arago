def elt_get_bfd_version(d):
	try:
		stdout, stderr = elt_run(d, 'as', '-v', '--version')
	except CmdError:
		return 'UNKNOWN'
	else:
		first_line = stdout.splitlines()[0]
		return first_line.split()[8]

ELT_VER_BFD := "${@elt_get_bfd_version(d)}"
