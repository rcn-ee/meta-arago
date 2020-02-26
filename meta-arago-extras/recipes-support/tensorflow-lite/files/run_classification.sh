#!/bin/sh

cd /usr/share/tensorflow-lite/demos

# Run tflite_classification binary with the model, the input image, and the label file specified.
# Classification label is overlayed with the input image. Right click the image display window to exit.
./tflite_classification -m ../examples/mobilenet_v1_1.0_224_quant.tflite -i ../examples/grace_hopper.bmp -l ../examples/labels.txt
