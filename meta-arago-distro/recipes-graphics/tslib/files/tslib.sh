#!/bin/sh

### Touchscreen Environment Variables ###

if [ -e /dev/input/touchscreen0 ]; then
    export TSLIB_TSDEVICE=/dev/input/touchscreen0

    mount | grep /run/media/mmcblk0p1 | grep vfat > /dev/null 2>&1
    if [ "$?" = "0" ]
    then
        export TSLIB_CALIBFILE=/run/media/mmcblk0p1/pointercal
    else
        export TSLIB_CALIBFILE=/etc/pointercal
    fi
fi
