#!/bin/sh

if [ -e /dev/input/touchscreen0 ]; then
	echo "Touch screen detected..."
	if [ -n "$LIBINPUT_CALIBRATION_MATRIX" ]; then
		echo "Calibration matrix already present, skipping calibration..."
	else
		echo "Calibrating touchscreen..."
		exec weston-calibrator
	fi
else
	echo "Touch screen not detected, skipping calibration..."
fi
