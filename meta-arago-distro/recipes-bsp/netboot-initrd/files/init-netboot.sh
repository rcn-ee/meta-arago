#!/bin/sh

export PATH=$PATH:/sbin:/usr/sbin

early_setup() {
    mkdir -p /proc /sys /tmp /run
    mount -t proc proc /proc
    mount -t sysfs sysfs /sys
    mount -t devtmpfs none /dev
}

beginswith() { case $2 in "$1"*) true;; *) false;; esac; }

read_args() {
    for arg in $2; do
        if beginswith "$1=" $arg ; then
		optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
		echo  $optarg
		break
	fi
    done
}

parse_server_info() {
    info=$1
    ip=$(echo $info | cut -s -d':' -f1 )
    info=${info#$ip:}
    path=$(echo $info | cut -d',' -f1 )
    info=${info#$path}
    options=${info#,}

    eval "$2=$ip"
    eval "$3=$path"
    eval "$4=$options"
}

do_dhcp() {
	if [ "$1" != "" ] ; then
		udhcpc -i $1
	else
		udhcpc
	fi
}

configure_eth_dev() {
	conf=$1

	client_ip=$(echo $conf | cut -s -d':' -f 1)
	server_ip=$(echo $conf | cut -s -d':' -f 2)
	gw_ip=$(echo $conf | cut -s -d':' -f 3)
	netmask=$(echo $conf | cut -s -d':' -f 4)
	hostname=$(echo $conf | cut -s -d':' -f 5)
	device=$(echo $conf | cut -s -d':' -f 6)
	autoconf=$(echo $conf | cut -s -d':' -f 7)
	dns0_ip=$(echo $conf | cut -s -d':' -f 8)
	dns1_ip=$(echo $conf | cut -s -d':' -f 9)

	if [ "$device" == "" ]; then
		device="eth0";
	fi

	echo waiting for device $device to come up
	while [ -z "$(ip link show $device 2> /dev/null)" ] ; do
		echo .;
		sleep 1
	done
	echo done


	ip link set $device up
	echo waiting establishment of link on $device
	while [ -z "$(ip link show $device | grep '<*LOWER_UP*>')" ] ; do
		echo .;
		sleep 1
	done
	echo done

	#handle the case 'ip=dhcp'
	if [ "$conf" == "dhcp" ] ; then
		do_dhcp
		return $?
	fi

	#handle the 'autoconf' case
	if [ "$autoconf" == "dhcp" ] ; then
		do_dhcp $device
		return $?
	fi

	if [ "$netmask" != "" ]; then
		ip addr add $client_ip/$netmask dev $device
	else
		ip addr add $client_ip dev $device
	fi

	if [ "$gw_ip" != "" ] ; then
		ip route add default via $gw_ip
	fi
	if [ "$dns0_ip" != "" ] ; then
		echo $dns0_ip >> /etc/resolv.conf
	fi
	if [ "$dns1_ip" != "" ] ; then
		echo $dns1_ip >> /etc/resolv.conf
	fi
}

early_setup
udevd --daemon
udevadm trigger
udevadm settle

cmdline=$(cat /proc/cmdline)

root_dev=$(read_args  root "$cmdline")
server_info=$(read_args nfsroot "$cmdline")
ip_info=$(read_args ip "$cmdline")

if [ "$root_dev" != "/dev/nfs" ]; then
	echo "invalid root device. It must be /dev/nfs"
	exit 1
fi

#
configure_eth_dev $ip_info
parse_server_info $server_info ip path options

# mount NFS drive
mkdir /newroot
mount -t nfs -o nolock,rw,$options $ip:$path /newroot

# switch root. new root is the NFS mount
exec switch_root /newroot /sbin/init
