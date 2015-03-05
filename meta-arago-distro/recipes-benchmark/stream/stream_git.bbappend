PR_append = "-arago0"

BRANCH = "sdk"
SRCREV = "cfd73a33c0ceef1f8532ce6a71de3bcf9435f6a2"

do_compile_prepend() {
    #Explicitly clear some variables to insure no unexpected optimizations are being passed in.
    unset CFLAGS
    unset LDFLAGS
}
