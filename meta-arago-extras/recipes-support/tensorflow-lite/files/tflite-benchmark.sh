#!/bin/sh

#list of model packages
declare -a model_list=(
"http://storage.googleapis.com/download.tensorflow.org/models/mobilenet_v1_2018_08_02/mobilenet_v1_1.0_224_quant.tgz"
"http://storage.googleapis.com/download.tensorflow.org/models/tflite_11_05_08/mobilenet_v2_1.0_224_quant.tgz"
"http://storage.googleapis.com/download.tensorflow.org/models/inception_v1_224_quant_20181026.tgz"
"http://storage.googleapis.com/download.tensorflow.org/models/inception_v2_224_quant_20181026.tgz"
"http://storage.googleapis.com/download.tensorflow.org/models/tflite_11_05_08/inception_v3_quant.tgz"
"http://storage.googleapis.com/download.tensorflow.org/models/inception_v4_299_quant_20181026.tgz"
"http://storage.googleapis.com/download.tensorflow.org/models/tflite/coco_ssd_mobilenet_v1_1.0_quant_2018_06_29.zip"
)

# create a new directory to host and unpack the models
rm -rf ~/tflite-benchmark
mkdir ~/tflite-benchmark

# Set maximal number of threads to the number of arm cores
max_num_threads=`nproc`

# TFLite install dir on filesystem
tflite_install_dir=$(find /usr/share -maxdepth 1 -type d -name "tensorflow-lite*")

for model_link in "${model_list[@]}"
do
  # download the model package to modeldir
  modelpkg="${model_link##*/}"
  modeldir="${modelpkg%.*}"

  mkdir ~/tflite-benchmark/$modeldir
  cd ~/tflite-benchmark/$modeldir

  echo "Downloading $modelpkg..."
  wget "$model_link"
  if [[ $? -ne 0 ]]; then
    echo "wget failed. Set up http proxy as needed before running the scripts!"
    exit 1
  fi

  # unpack the model package
  if [[ $modelpkg =~ \.tgz$ ]]; then
    tar -xzvf $modelpkg
  fi
  if [[ $modelpkg =~ \.zip$ ]]; then
    unzip $modelpkg
  fi

  # run benchmark for the model
  for model in *.tflite; do
    for num_threads in $( seq 1 $max_num_threads )
      do
        echo "Running benchmark_model for $model with $num_threads thread(s)..."
        $tflite_install_dir/examples/benchmark_model --graph=${model} --num_threads=$num_threads --enable_op_profiling=true > ${modeldir}_thread_${num_threads}.log
        cat ${modeldir}_thread_${num_threads}.log | grep Timings
      done
  done
done

echo "Benchmarking completed!"
