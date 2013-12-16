################################################################################
######################### TSU EXEMPTION REQUIRED ###############################
################################################################################
# Versions of openssl that are TSU Exempted:
# openssl-1.0.0a
# openssl-1.0.0d
#
# This package requires TSU exemption. Any update to the version of openssl being
# appended must be double checked to see if a new TSU exemption must be made.

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR_append = "-arago8"

DEPENDS_append_ti33x_class-target = " cryptodev"
DEPENDS_append_ti43x_class-target = " cryptodev"
DEPENDS_append_dra7xx-evm_class-target = " cryptodev"

python __anonymous () {
    crypdep = d.getVar("DEPENDS").replace("ocf-linux ", "")
    d.setVar("DEPENDS_ti33x_class-target", crypdep)
    d.setVar("DEPENDS_ti43x_class-target", crypdep)
    d.setVar("DEPENDS_dra7xx-evm_class-target", crypdep)
}

CRYPTODEV_AFALG_PATCHES = " \
	file://0001-Add-AF_ALG-interface-support-to-OpenSSL.patch \
	file://0002-Modify-eng_cryptodev.c-to-make-SHA1-and-MD5-work-wit.patch \
	file://0004-Sample-AF_ALG-openssl.cnf.patch \
	file://0001-eng_cryptodev.c-update-to-cryptodev-1.6.patch \
	file://0009-eng_cryptodev-Add-SHA224-initialization-to-cryptodev.patch \
	file://0011-cryptodev-Add-AES-CBC-CTR-modes-for-128-192-256-bit-.patch \
"

SRC_URI_append_ti33x_class-target = "${CRYPTODEV_AFALG_PATCHES}"
SRC_URI_append_ti43x_class-target = "${CRYPTODEV_AFALG_PATCHES}"
SRC_URI_append_dra7xx-evm_class-target = "${CRYPTODEV_AFALG_PATCHES}"

# Override do_configure to replace target with linux-armv4 to enable ASM code
# optimization for ARM arch (including armv7) for extra performance
do_configure () {
	cd util
	perl perlpath.pl ${STAGING_BINDIR_NATIVE}
	cd ..
	ln -sf apps/openssl.pod crypto/crypto.pod ssl/ssl.pod doc/

	os=${HOST_OS}
	if [ "x$os" = "xlinux-uclibc" ]; then
		os=linux
	elif [ "x$os" = "xlinux-uclibceabi" ]; then
		os=linux
	elif [ "x$os" = "xlinux-gnueabi" ]; then
		os=linux
	fi
	target="$os-${HOST_ARCH}"
	case $target in
	linux-arm)
		# target=linux-elf-arm
		target=linux-armv4
		;;
	linux-armeb)
		target=linux-elf-armeb
		;;
	linux-sh3)
		target=debian-sh3
		;;
	linux-sh4)
		target=debian-sh4
		;;
	linux-i486)
		target=debian-i386-i486
		;;
	linux-i586 | linux-viac3)
		target=debian-i386-i586
		;;
	linux-i686)
		target=debian-i386-i686/cmov
		;;
	linux-gnux32-x86_64)
		target=linux-x32
		;;
	linux-gnu64-x86_64)
		target=linux-x86_64
		;;
	linux-mips)
		target=debian-mips
		;;
	linux-mipsel)
		target=debian-mipsel
		;;
	linux-*-mips64)
		target=linux-mips
		;;
	linux-powerpc)
		target=linux-ppc
		;;
	linux-gnuspe-powerpc)
		target=linux-ppc
		;;
	linux-powerpc64)
		target=linux-ppc64
		;;
	linux-supersparc)
		target=linux-sparcv8
		;;
	linux-sparc)
		target=linux-sparcv8
		;;
	darwin-i386)
		target=darwin-i386-cc
		;;
	esac
	# inject machine-specific flags
	sed -i -e "s|^\(\"$target\",\s*\"[^:]\+\):\([^:]\+\)|\1:${CFLAG}|g" Configure
	useprefix=${prefix}
	if [ "x$useprefix" = "x" ]; then
		useprefix=/
	fi
	perl ./Configure ${EXTRA_OECONF} shared --prefix=$useprefix --openssldir=${libdir}/ssl --libdir=`basename ${libdir}` $target
}
