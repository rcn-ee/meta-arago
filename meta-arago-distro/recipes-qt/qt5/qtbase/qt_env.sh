#!/bin/sh

### QT Environment Variables ###
export QT_QPA_GENERIC_PLUGINS=Auto
export QT_QPA_PLATFORM=wayland


# Set the QT_QPA_GENERIC_PLUGINS for touchscreen if it exists
if [ -e /dev/input/touchscreen0 ]
then
    export QT_QPA_GENERIC_PLUGINS=Tslib:/dev/input/touchscreen0
fi
