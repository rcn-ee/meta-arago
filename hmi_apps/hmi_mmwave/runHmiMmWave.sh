#!/bin/bash

/etc/init.d/weston stop
sleep 1

mmwavegesture -platform eglfs

/etc/init.d/weston start
sleep 1
