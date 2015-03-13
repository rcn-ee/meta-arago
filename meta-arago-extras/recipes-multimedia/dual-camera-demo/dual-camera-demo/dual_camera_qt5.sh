#!/bin/bash

/etc/init.d/matrix-gui-2.0 stop

echo 0 > /sys/class/graphics/fbcon/cursor_blink

dual_camera

echo 1 > /sys/class/graphics/fbcon/cursor_blink

/etc/init.d/matrix-gui-2.0 start

