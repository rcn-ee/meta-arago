#!/bin/sh
usage() {
    cat << EOF

  Usage:
         $0 <fw-type: opencl, tiovx>

EOF
}

if [ "$1" ]; then
case "$1" in
    opencl) echo "Reload opencl firmware to DSP"
        ;;
    tiovx) echo "Reload tiovx firmware to DSP"
        ;;
    *) echo "Wrong argument $1"
       usage
       exit
        ;;
esac
else
       usage
       exit
fi

fw="${1}"

if [[ ${fw} == opencl ]]; then
    #Start OpenCL CMEM memory allocation daemon
    if pgrep -x "ti-mctd" > /dev/null
    then
        echo "ti-mctd is running"
    else
        echo "Starting ti-mctd..."
        ti-mctd
    fi
    # Link opencl monitor firmware for DSPs
    ln -s -f /lib/firmware/dra7-dsp1-fw.xe66.opencl-monitor /lib/firmware/dra7-dsp1-fw.xe66
    ln -s -f /lib/firmware/dra7-dsp2-fw.xe66.opencl-monitor /lib/firmware/dra7-dsp2-fw.xe66
fi

if [[ ${fw} == tiovx ]]; then
    # Kill CMEM multi-process daemon. This releases all CMEM memory used by OpenCL memory allocation
    pkill ti-mctd

    # Link tiovx firmware for DSPs
    ln -s -f /lib/firmware/dra7-dsp1-fw.xe66.openvx /lib/firmware/dra7-dsp1-fw.xe66
    ln -s -f /lib/firmware/dra7-dsp2-fw.xe66.openvx /lib/firmware/dra7-dsp2-fw.xe66
fi

cd /sys/bus/platform/drivers/omap-rproc/

# release DSPs
echo "Releasing DSPs..."
echo 40800000.dsp > unbind

echo 41000000.dsp > unbind

# reload firmware for DSPs
echo "Reloading firmware for DSPs..."
echo 40800000.dsp > bind

echo 41000000.dsp > bind

cd ~-
