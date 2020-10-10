PR_append = ".arago0"

SRC_URI = "git://git.ti.com/optee/ti-optee-os.git;branch=${BRANCH} \
           file://0001-allow-setting-sysroot-for-libgcc-lookup.patch \
"
BRANCH = "ti-optee-os"
SRCREV = "199fca17b575d4c748c9c435e908a6ec9618c75a"
