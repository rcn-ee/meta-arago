#!/bin/bash
#Permission is hereby granted, free of charge, to any person obtaining a copy
#of this software and associated documentation files (the "Software"), to deal
#in the Software without restriction, including without limitation the rights
#to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
#copies of the Software, and to permit persons to whom the Software is
#furnished to do so, subject to the following conditions:
#
#The above copyright notice and this permission notice shall be included in
#all copies or substantial portions of the Software.
#
#THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
#IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
#FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
#AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
#LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
#OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
#THE SOFTWARE.

function bten_335_evm {
	echo 117 > /sys/class/gpio/export
	echo out > /sys/class/gpio/gpio117/direction
	echo 0 > /sys/class/gpio/gpio117/value
	sleep 1
	echo 1 > /sys/class/gpio/gpio117/value
	echo "Done enabling BT"

	local gpio="nshutdown_gpio=117"
	local tty="tty=/dev/ttyS1"
	local flow="flow_cntrl=1"
	local baud_rate="baud_rate=3000000"
	mkdir /home/root/tibt
	echo $gpio > /home/root/tibt/config
	echo $tty >> /home/root/tibt/config
	echo $flow >> /home/root/tibt/config
	echo $baud_rate >> /home/root/tibt/config
}

function bten_437_evm {
	echo 16 > /sys/class/gpio/export
	echo out > /sys/class/gpio/gpio16/direction
	echo 0 > /sys/class/gpio/gpio16/value
	sleep 1
	echo 1 > /sys/class/gpio/gpio16/value
	echo "Done enabling BT"

	local gpio="nshutdown_gpio=16"
	local tty="tty=/dev/ttyS3"
	local flow="flow_cntrl=1"
	local baud_rate="baud_rate=3000000"
	mkdir /home/root/tibt
	echo $gpio > /home/root/tibt/config
	echo $tty >> /home/root/tibt/config
	echo $flow >> /home/root/tibt/config
	echo $baud_rate >> /home/root/tibt/config
}

function bten_57x_evm {
	echo 132 > /sys/class/gpio/export
	echo out > /sys/class/gpio/gpio132/direction
	echo 0 > /sys/class/gpio/gpio132/value
	sleep 1
	echo 1 > /sys/class/gpio/gpio132/value
	echo "Done enabling BT"

	local gpio="nshutdown_gpio=132"
	local tty="tty=/dev/ttyS7"
	local flow="flow_cntrl=1"
	local baud_rate="baud_rate=3000000"
	mkdir /home/root/tibt
	echo $gpio > /home/root/tibt/config
	echo $tty >> /home/root/tibt/config
	echo $flow >> /home/root/tibt/config
	echo $baud_rate >> /home/root/tibt/config
}

function bten_43x_epos_evm {
	echo 21 > /sys/class/gpio/export
	echo out > /sys/class/gpio/gpio21/direction
	echo 0 > /sys/class/gpio/gpio21/value
	sleep 1
	echo 1 > /sys/class/gpio/gpio21/value
	echo "Done enabling BT"

	local gpio="nshutdown_gpio=21"
	local tty="tty=/dev/ttyS3"
	local flow="flow_cntrl=1"
	local baud_rate="baud_rate=3000000"
	mkdir /home/root/tibt
	echo $gpio > /home/root/tibt/config
	echo $tty >> /home/root/tibt/config
	echo $flow >> /home/root/tibt/config
	echo $baud_rate >> /home/root/tibt/config
}

b=$(cat /proc/device-tree/model)
echo "$b"
if [ `echo $b | grep -c "TI"` -gt 0 ]
then
	if [ `echo $b | grep -c "EVM"` -gt 0 ]
	then
		if [ `echo $b | grep -c "335"` -gt 0 ]
		then
			echo "success"
			bten_335_evm
		fi
		if [ `echo $b | grep -c "437"` -gt 0 ]
		then
			echo "success"
			bten_437_evm
		fi
		if [ `echo $b | grep -c "572"` -gt 0 ]
		then
			echo "success"
			bten_57x_evm
		fi
		if [ `echo $b | grep -c "EPOS"` -gt 0 ]
		then
			echo "success"
			bten_43x_epos_evm
		fi
	else
		echo "Not TI EVM board"
	fi
else
	echo "Not a TI board"
fi
