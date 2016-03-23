#!/bin/bash

/etc/init.d/weston stop
sleep 1

echo 0 > /sys/class/graphics/fbcon/cursor_blink

dual_camera 2 -platform linuxfb

echo 1 > /sys/class/graphics/fbcon/cursor_blink

/etc/init.d/weston start
sleep 1
