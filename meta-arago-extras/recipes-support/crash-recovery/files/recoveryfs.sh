#*
#* Copyright (C) 2012-2014 Texas Instruments Incorporated - http://www.ti.com/
#*
#*
#*  Redistribution and use in source and binary forms, with or without
#*  modification, are permitted provided that the following conditions
#*  are met:
#*
#*    Redistributions of source code must retain the above copyright
#*    notice, this list of conditions and the following disclaimer.
#*
#*    Redistributions in binary form must reproduce the above copyright
#*    notice, this list of conditions and the following disclaimer in the
#*    documentation and/or other materials provided with the
#*    distribution.
#*
#*    Neither the name of Texas Instruments Incorporated nor the names of
#*    its contributors may be used to endorse or promote products derived
#*    from this software without specific prior written permission.
#*

#!/bin/sh

if [ -f /proc/vmcore ] ; then
  mkdir -p /mnt/boot2
  mount -o rw,sync -t ubifs /dev/ubi0_2 /mnt/boot2
  if [ $? -eq 0 ] ; then
     if [ -f /usr/bin/makedumpfile ] ; then
       makedumpfile -E -d 31 /proc/vmcore /mnt/boot2/home/root/coredump.elf
       gzip -c /mnt/boot2/home/root/coredump.elf > /mnt/boot2/home/root/coredump.elf.gz
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
