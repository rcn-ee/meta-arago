#!/bin/sh

if [ -f /proc/vmcore ] ; then
  mkdir -p /mnt/boot2
  mount -t ubifs /dev/ubi0_2 /mnt/boot2
  if [ $? -eq 0 ] ; then
     if [ -f /usr/bin/makedumpfile ] ; then
       makedumpfile -E -d 31 /proc/vmcore /mnt/boot2/home/root/coredump.elf
       gzip -c /mnt/boot2/home/root/coredump.elf > \
           /mnt/boot2/home/root/coredump.elf.gz
       rm -rf /mnt/boot2/home/root/coredump.elf
       sync
       reboot
     else
       echo "makedumpfile not found"
       exit 1
     fi
  else
    echo "mount unsuccessful"
    exit 1
  fi
fi

exit 0
