INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN}-openmp += "ldflags"

PR_append = "-arago1"

BRANCH = "sdk"
SRCREV = "96156d407d9a4e5fac4513f3d3f60a414b3355cd"

do_compile_prepend() {
    #Explicitly clear some variables to insure no unexpected optimizations are being passed in.
    unset CFLAGS
    unset LDFLAGS
}
