SUMMARY = "TI Big data IPC: Host linux examples"

require recipes-ti/includes/ti-paths.inc
require big-data-ipc-demo.inc

DEPENDS = "ti-ipc \
           ti-xdctools-native \
           ti-sysbios \
           ti-ipc-rtos \
           cmem \
           ti-cgt6x-native \
"

EXTRA_OEMAKE = "\
    PLATFORM=${PLATFORM} \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    BIOS_INSTALL_DIR="${SYSBIOS_INSTALL_DIR}" \
    IPC_INSTALL_DIR="${IPC_INSTALL_DIR}" \
    LINUX_SYSROOT_DIR="${STAGING_INCDIR}" \
    ${IPC_TARGETS} \
    JOBS="${PARALLEL_MAKE}" \
"

do_create_srcipk_prepend() {
  rm -rf host_bios
}

do_compile() {
  if [  "${PLATFORM}" != "UNKNOWN" ]; then
      oe_runmake host_linux
  fi
}

do_install() {
  if [  "${PLATFORM}" != "UNKNOWN" ]; then
    oe_runmake EXEC_DIR="${D}${bindir}" install_linux_bin
  fi
}

PACKAGES =+ "${PN}-firmware"
FILES_${PN}-firmware += "${bindir}/simple_buffer_example/release/server_dsp.xe66"
INSANE_SKIP_${PN}-firmware += "arch"
