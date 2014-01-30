PR_append = "-arago0"

PACKAGECONFIG := "${@oe_filter_out('x264','${PACKAGECONFIG}', d)}"
LICENSE_FLAGS = ""

# Disable features that have potential commercial licensing restrictions
EXTRA_OECONF += "\
    --disable-encoder=libmp3lame \
    --disable-decoder=mp3 \
    --disable-decoder=mp3adu \
    --disable-decoder=mp3adufloat \
    --disable-decoder=mp3float \
    --disable-decoder=mp3on4 \
    --disable-decoder=mp3on4float \
    --disable-muxer=mp3 \
    --disable-demuxer=mp3 \
    --disable-bsf=mp3_header_decompress \
    --disable-bsf=mp3_header_compress   \
                                 \
    --disable-encoder=mpeg2video \
    --disable-decoder=mpeg2video \
    --disable-hwaccel=mpeg2_vaapi \
    --disable-hwaccel=mpeg2_dxva2 \
    --disable-muxer=mpeg2dvd \
    --disable-muxer=mpeg2svcd \
    --disable-muxer=mpeg2video \
    --disable-muxer=mpeg2vob \
                            \
    --disable-encoder=ac3_fixed \
    --disable-encoder=ac3 \
    --disable-decoder=ac3 \
    --disable-decoder=eac3 \
    --disable-demuxer=ac3 \
    --disable-demuxer=eac3 \
    --disable-demuxer=dts \
    --disable-muxer=ac3 \
    --disable-muxer=eac3 \
    --disable-muxer=dts \
    --disable-parser=ac3 \
"
