#!/bin/sh

cd /usr/share/tensorflow-lite/demos

# Run tflite_segmentation binary with the model and the input image specified.
# The display window shows the input(resized) image, segmentation map, overlay
# of the former two. Right click the image display window to exit.
./tflite_segmentation -m ./deeplabv3_257_mv_gpu.tflite -i ./bird_segmentation.bmp
