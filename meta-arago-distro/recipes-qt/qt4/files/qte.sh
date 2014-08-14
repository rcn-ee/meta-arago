#!/bin/sh

### QT Environment Variables ###
export QWS_MOUSE_PROTO=Auto


# Set the QWS_MOUSE_PROTO for touchscreen if it exists
if [ -e /dev/input/touchscreen0 ]
then
    export QWS_MOUSE_PROTO=Tslib:/dev/input/touchscreen0
fi
