#!/bin/sh

# on first connection to a new AP we need to trigger the dhcp client for
# getting an ip address

cat /var/run/udhcpc.wlan0.pid | xargs /bin/kill -SIGUSR1
