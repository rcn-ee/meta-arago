#!/bin/sh

/etc/init.d/matrix-gui-2.0 stop

export TSLIB_TSDEVICE=/dev/input/touchscreen0
export QWS_MOUSE_PROTO=Tslib:/dev/input/touchscreen0

dual_camera -qws

/etc/init.d/matrix-gui-2.0 start
