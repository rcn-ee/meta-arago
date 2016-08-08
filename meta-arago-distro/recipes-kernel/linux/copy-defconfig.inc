CONFIG_NAME ?= "tisdk_${MACHINE}_defconfig"

# Copy the configuration file used during the SDK build in Arago to
# the kernel sources to be packaged into the sourceipk.  Then call
# the function to build the sourceipk again.  This is done as a
# do_compile_prepend so that we can pick up any changes to the
# defconfig thay may have been done by the sanitizer code.
do_configure_append() {
    cp ${B}/.config ${S}/arch/arm/configs/${CONFIG_NAME}
}

# Move create_srcipk task so that the release defconfig is included.
deltask do_create_srcipk
addtask create_srcipk after do_configure before do_compile
