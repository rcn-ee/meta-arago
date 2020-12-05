PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-os.git;branch=${BRANCH} \
           file://0001-allow-setting-sysroot-for-libgcc-lookup.patch \
"
BRANCH = "ti-optee-os"
SRCREV = "f414104d552c8ab96ccc3c4182c395c20e3a0a34"
