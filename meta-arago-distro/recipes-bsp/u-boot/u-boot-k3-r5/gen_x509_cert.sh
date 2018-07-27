#!/bin/bash
#
# Script to add x509 certificate to binary/ELF

# Variables
VALID_SHAS="sha256 sha384 sha512 sha224"
OUTPUT=x509-firmware.bin
TEMP_X509=x509-temp.cert
CERT=certificate.bin
RAND_KEY=eckey.pem
VALID_ROM_CORES="r5 m3"
VALID_DMSC_CORES="r5-00 r5-01 a53-00 a53-01 a53-10 a53-11"
SHA=sha512
CORE=m3
LOADADDR=0x00040000
VALID_MASTERS="rom dmsc"

declare -A sha_oids
sha_oids["sha256"]=2.16.840.1.101.3.4.2.1
sha_oids["sha384"]=2.16.840.1.101.3.4.2.2
sha_oids["sha512"]=2.16.840.1.101.3.4.2.3
sha_oids["sha224"]=2.16.840.1.101.3.4.2.4

declare -A core_ids
core_ids["a53-00"]=0x20
core_ids["a53-01"]=0x21
core_ids["a53-10"]=0x22
core_ids["a53-11"]=0x23
core_ids["r5-00"]=0x01
core_ids["r5-01"]=0x02

gen_key() {
	openssl ecparam -out $RAND_KEY -name prime256v1 -genkey
	KEY=$RAND_KEY
}

declare -A options_help
usage() {
	if [ -n "$*" ]; then
		echo "ERROR: $*"
	fi
	echo -n "Usage: $0 "
	for option in "${!options_help[@]}"
	do
		arg=`echo ${options_help[$option]}|cut -d ':' -f1`
		if [ -n "$arg" ]; then
			arg=" $arg"
		fi
		echo -n "[-$option$arg] "
	done
	echo
	echo -e "\nWhere:"
	for option in "${!options_help[@]}"
	do
		arg=`echo ${options_help[$option]}|cut -d ':' -f1`
		txt=`echo ${options_help[$option]}|cut -d ':' -f2`
		tb="\t\t\t"
		if [ -n "$arg" ]; then
			arg=" $arg"
			tb="\t"
		fi
		echo -e "   -$option$arg:$tb$txt"
	done
	echo
	echo "Examples of usage:-"
	echo "# Generate x509 certificate with random key from elf"
	echo "    CROSS_COMPILE=arm-linux-gnueabihf- $0 -b ti-sci-firmware-am6x.elf -o dmsc.bin -l 0x40000"
	echo "# Generate x509 certificate with random key from bin"
	echo "    $0 -b ti-sci-firmware-am6x.bin -o dmsc.bin -l 0x40000"
	echo "# Example of signing the DMSC binary"
	echo "    $0 -m rom -c m3 -b ti-sci-firmware-am6x.bin -o dmsc.bin -l 0x40000"
	echo "# Example of signing the SPL binary"
	echo "    $0 -m rom -c r5 -b spl/u-boot-spl.bin -o tiboot3.bin -l 0x41c00000"
	echo "# Example of signing the ATF binary to run on A53"
	echo "    $0 -m dmsc -c a53-00 -b bl31.bin -o atf.bin -l 0x70000000"
}

options_help[e]="elf_file:ELF file that needs to be signed"
options_help[b]="bin_file:Bin file that needs to be signed"
options_help[k]="key_file:file with key inside it. If not provided script generates a random key."
options_help[o]="output_file:Name of the final output file. default x509-firmware.bin"
options_help[c]="core:target core on which the image would be running. Default is m3. Valid option for rom are $VALID_ROM_CORES. Valid options for DMSC are $VALID_DMSC_CORES"
options_help[d]=":Countersign DMSC firmware image. This signs a previously signed image for a second time."
options_help[s]="sha_type:sha type to be used for certificate generation. Default is sha512. Valid option are $VALID_SHAS"
options_help[l]="loadaddr: Target load address of the binary in hex. Default to $LOADADDR"
options_help[m]="master: Master name for which the image is created. This master software parses the certificate and load the images accordingly. Default to rom. valid options are $VALID_MASTERS"

while getopts "e:b:k:o:c:ds:l:m:h" opt
do
	case $opt in
	e)
		ELF=$OPTARG
	;;
	b)
		BIN=$OPTARG
	;;
	k)
		KEY=$OPTARG
	;;
	o)
		OUTPUT=$OPTARG
	;;
	l)
		LOADADDR=$OPTARG
	;;
	s)
		SHA=$OPTARG
		sha_valid=0
		for tsha in $VALID_SHAS
		do
			if [ "$tsha" == "$SHA" ]; then
				sha_valid=1
			fi
		done
		if [ $sha_valid == 0 ]; then
			usage "Invalid sha input $SHA"
			exit 1
		fi
	;;
	c)
		CORE=$OPTARG
	;;
	d)
		CERTTYPE=3	# CERT_TYPE_FIRMWARE_COUNTERSIGN
	;;
	m)
		MASTER=$OPTARG
		master_valid=0
		for vmaster in $VALID_MASTERS
		do
			if [ "$vmaster" == "$MASTER" ]; then
				master_valid=1
			fi
		done
		if [ $master_valid == 0 ]; then
			usage "Invalid master input $MASTER"
			exit 1
		fi
	;;
	h)
		usage
		exit 0
	;;
	\?)
		usage "Invalid Option '-$OPTARG'"
		exit 1
	;;
	:)
		usage "Option '-$OPTARG' Needs an argument."
		exit 1
	;;
	esac
done

if [ "$#" -eq 0 ]
then
	usage "Arguments missing"
	exit 1
fi

if [ -z "$BIN" -a -z "$ELF" ]; then
	usage "Either Input bin file or ELF file to sign"
	exit 1
fi

if [ "$MASTER" == "dmsc" ]; then
	VALID_CORES=$VALID_DMSC_CORES
else
	# Defaut to ROM image
	VALID_CORES=$VALID_ROM_CORES
	MASTER="rom"
fi

# Verify for valid core inputs
core_valid=0
for tcore in $VALID_CORES
do
	if [ "$tcore" == "$CORE" ]; then
		core_valid=1
	fi
done
if [ $core_valid == 0 ]; then
	usage "Invalid target core $CORE"
	exit 1
fi

# Generate random key if user doesn't provide a key
if [ -z "$KEY" ]; then
	gen_key
fi

if [ "$MASTER" == "dmsc" ]; then
	BOOTCORE=${core_ids["$CORE"]}
	BOOTCORE_OPTS_VER=$(printf "%01x" 1)
	# Add input args option for SET and CLR flags.
	BOOTCORE_OPTS_SETFLAG=$(printf "%08x" 0)
	BOOTCORE_OPTS_CLRFLAG=$(printf "%08x" 0x100) # Clear FLAG_ARMV8_AARCH32
	BOOTCORE_OPTS="0x$BOOTCORE_OPTS_VER$BOOTCORE_OPTS_SETFLAG$BOOTCORE_OPTS_CLRFLAG"
	# Set the cert type to zero.
	# We are not using public/private key store now
	CERTTYPE=$(printf "0x%08x" 0)
else
	if [ "$CORE" == "m3" ]; then
		if [ -z "$CERTTYPE" ]; then
			CERTTYPE=2	# CERT_TYPE_FIRMWARE_IMAGE_BIN
		fi
		BOOTCORE=0		# DMSC Controller (M3)
		BOOTCORE_OPTS=32
	else
		CERTTYPE=1		# CERT_TYPE_PRIMARY_IMAGE_BIN
		BOOTCORE=16		# MCU (R5)
		BOOTCORE_OPTS=32
	fi
fi

if [ -z "$BIN" ]; then
	echo "Generating bin from elf $ELF"
	BIN=firmware.bin
	${CROSS_COMPILE}objcopy -g -S --gap-fill 0x0 -O binary $ELF $BIN
	if [ "$?" != "0" ]; then
		echo "ERROR: Generating bin from $ELF failed. CROSS_COMPILE?"
		exit 1
	fi
fi

SHA_OID=${sha_oids["$SHA"]}
SHA_VAL=`openssl dgst -$SHA -hex $BIN | sed -e "s/^.*= //g"`
BIN_SIZE=`cat $BIN | wc -c`
ADDR=`printf "%08x" $LOADADDR`

# Generate x509 Template
gen_template() {
cat << 'EOF' > x509-template.txt
 [ req ]
 distinguished_name     = req_distinguished_name
 x509_extensions        = v3_ca
 prompt                 = no
 dirstring_type         = nobmp

 [ req_distinguished_name ]
 C                      = US
 ST                     = SC
 L                      = New York
 O                      = Texas Instruments., Inc.
 OU                     = DSP
 CN                     = Albert
 emailAddress           = Albert@gt.ti.com

 [ v3_ca ]
 basicConstraints = CA:true
 1.3.6.1.4.1.294.1.1 = ASN1:SEQUENCE:boot_seq
 1.3.6.1.4.1.294.1.2 = ASN1:SEQUENCE:image_integrity
 1.3.6.1.4.1.294.1.3 = ASN1:SEQUENCE:swrv
# 1.3.6.1.4.1.294.1.4 = ASN1:SEQUENCE:encryption
 1.3.6.1.4.1.294.1.8 = ASN1:SEQUENCE:debug

 [ boot_seq ]
 certType = INTEGER:TEST_CERT_TYPE
 bootCore = INTEGER:TEST_BOOT_CORE
 bootCoreOpts = INTEGER:TEST_BOOT_CORE_OPTS
 destAddr = FORMAT:HEX,OCT:TEST_BOOT_ADDR
 imageSize = INTEGER:TEST_IMAGE_LENGTH

 [ image_integrity ]
 shaType = OID:TEST_IMAGE_SHA_OID
 shaValue = FORMAT:HEX,OCT:TEST_IMAGE_SHA_VAL

 [ swrv ]
 swrv = INTEGER:0

# [ encryption ]
# initalVector = FORMAT:HEX,OCT:TEST_IMAGE_ENC_IV
# randomString = FORMAT:HEX,OCT:TEST_IMAGE_ENC_RS
# iterationCnt = INTEGER:TEST_IMAGE_KEY_DERIVE_INDEX
# salt = FORMAT:HEX,OCT:TEST_IMAGE_KEY_DERIVE_SALT

 [ debug ]
 debugUID = FORMAT:HEX,OCT:0000000000000000000000000000000000000000000000000000000000000000
 debugType = INTEGER:4
 coreDbgEn = INTEGER:0
 coreDbgSecEn = INTEGER:0
EOF
}

gen_cert() {
	echo "Certificate being generated :"
	echo "	LOADADDR = 0x$ADDR"
	echo "	IMAGE_SIZE = $BIN_SIZE"
	echo "	CERT_TYPE = $CERTTYPE"
	sed -e "s/TEST_IMAGE_LENGTH/$BIN_SIZE/"	\
		-e "s/TEST_IMAGE_SHA_OID/$SHA_OID/" \
		-e "s/TEST_IMAGE_SHA_VAL/$SHA_VAL/" \
		-e "s/TEST_CERT_TYPE/$CERTTYPE/" \
		-e "s/TEST_BOOT_CORE_OPTS/$BOOTCORE_OPTS/" \
		-e "s/TEST_BOOT_CORE/$BOOTCORE/" \
		-e "s/TEST_BOOT_ADDR/$ADDR/" x509-template.txt > $TEMP_X509
	openssl req -new -x509 -key $KEY -nodes -outform DER -out $CERT -config $TEMP_X509 -$SHA
}

gen_template
gen_cert
cat $CERT $BIN > $OUTPUT

echo "SUCCESS: Image $OUTPUT generated."

# Remove all intermediate files
rm $TEMP_X509 $CERT x509-template.txt
if [ "$KEY" == "$RAND_KEY" ]; then
	rm $RAND_KEY
fi

